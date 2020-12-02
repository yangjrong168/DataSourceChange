package com.example.DataSourceChange;

import com.example.DataSourceChange.common.RoutingDataSource;
import com.example.DataSourceChange.common.config.DataSourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DataSourceChangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataSourceChangeApplication.class, args);
	}






}
