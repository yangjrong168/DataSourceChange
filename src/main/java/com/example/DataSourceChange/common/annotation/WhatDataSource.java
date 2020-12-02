package com.example.DataSourceChange.common.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface WhatDataSource {
    String name() default "masterDataSource";
}
