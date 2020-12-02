package com.example.DataSourceChange.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        String key =  DynamicDataSourceContextHolder.getDataSourceType();
        if(key == null){
            return "masterDataSource";
        }else{
            return key;
        }

    }
}
