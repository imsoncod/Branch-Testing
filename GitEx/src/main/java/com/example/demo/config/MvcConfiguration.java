package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.interceptor.LoggerInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new LoggerInterceptor())
		.excludePathPatterns("/user/**");
	}

	
	
}
