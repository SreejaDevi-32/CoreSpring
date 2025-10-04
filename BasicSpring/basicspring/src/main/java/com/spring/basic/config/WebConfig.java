package com.spring.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.basic.interceptor.AuthInterceptor;

@Configuration
@ComponentScan(basePackages= {"com.spring"})
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	AuthInterceptor autoInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(autoInterceptor)
				.addPathPatterns("/user/**");
				
	}

}
