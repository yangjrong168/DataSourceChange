package com.example.DataSourceChange.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicDataSourceContextHolder {



    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();


    public static void setDataSourceType(String dataSourceType) {
        log.info("已切换到{}数据源", dataSourceType);
        contextHolder.set(dataSourceType);
    }


    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void removeDataSourceType() {
        contextHolder.remove();
    }
}
