package com.cafe24.noahshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cafe24.config.app.MyBatisConfig;
import com.cafe24.config.app.TestDBConfig;

@Configuration
@Import({TestDBConfig.class, MyBatisConfig.class})
@ComponentScan({"com.cafe24.noahshop.service", "com.cafe24.noahshop.repository"})
public class TestAppConfig {

}
