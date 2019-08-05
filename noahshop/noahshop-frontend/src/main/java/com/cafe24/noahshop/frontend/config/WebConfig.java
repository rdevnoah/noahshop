package com.cafe24.noahshop.frontend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.noahshop.frontend.config.web.MVCConfig;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.example.pjmall.frontend.controller", "com.example.pjmall.frontend.exception"})
@Import({ MVCConfig.class })
public class WebConfig {
}
