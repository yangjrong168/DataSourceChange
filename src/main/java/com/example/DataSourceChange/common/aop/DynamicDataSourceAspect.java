package com.example.DataSourceChange.common.aop;

import com.example.DataSourceChange.common.DynamicDataSourceContextHolder;
import com.example.DataSourceChange.common.annotation.WhatDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(-1) // 保证该AOP在@Transactional之前执行
@Slf4j
public class DynamicDataSourceAspect {



    @Pointcut("@annotation(com.example.DataSourceChange.common.annotation.WhatDataSource)"
            + "|| @within(com.example.DataSourceChange.common.annotation.WhatDataSource)")
    public void dsPointCut()  {
    }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Method targetMethod = this.getTargetMethod(point);
        WhatDataSource dataSource = targetMethod.getAnnotation(WhatDataSource.class);//获取要切换的数据源
        if (dataSource != null)  {
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.name());
        }
        try {
            return point.proceed();
        }
        finally  {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.removeDataSourceType();
        }
    }

    private Method getTargetMethod(ProceedingJoinPoint pjp) throws NoSuchMethodException {
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method agentMethod = methodSignature.getMethod();
        return pjp.getTarget().getClass().getMethod(agentMethod.getName(), agentMethod.getParameterTypes());
    }
}