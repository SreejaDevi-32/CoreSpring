package com.spring.core.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages= {"com.spring.core.aop","com.spring.core.Interceptor","com.spring.core.config"})
public class AOPApplication {
	public static void main(String[] args) {
		ApplicationContext aop = SpringApplication.run(AOPApplication.class, args);
		
	}

}
