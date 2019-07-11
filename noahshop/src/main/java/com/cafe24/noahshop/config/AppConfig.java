package com.cafe24.noahshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cafe24.config.app.DBConfig;
import com.cafe24.config.app.MyBatisConfig;

@Configuration
@Import({DBConfig.class, MyBatisConfig.class})
@ComponentScan({"com.cafe24.noahshop.service"})
public class AppConfig {

}
