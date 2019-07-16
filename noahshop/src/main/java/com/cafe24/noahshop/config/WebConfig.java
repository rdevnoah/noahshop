package com.cafe24.noahshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cafe24.config.web.MVCConfig;
import com.cafe24.config.web.MessageConfig;

@Configuration
@EnableWebMvc
@ComponentScan({"com.cafe24.noahshop.controller", "com.cafe24.noahshop.exception"})
@Import({SwaggerConfig.class, MVCConfig.class, MessageConfig.class})
public class WebConfig {

}
