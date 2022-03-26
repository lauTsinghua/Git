package com.cy.pj.common.config;

import com.cy.pj.common.web.TimeAccessInterceptor;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
* 拦截器:拦截路径相关的页面
* */

@Configuration
public class SpringWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeAccessInterceptor()).addPathPatterns("/user/doLogin");


    }
}
