package com.cafe24.noahshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.cafe24.noahshop.controller")
@Import({SwaggerConfig.class, TestMVCConfig.class})
public class TestWebConfig{
}
