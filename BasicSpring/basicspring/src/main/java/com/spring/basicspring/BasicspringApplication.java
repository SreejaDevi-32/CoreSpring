package com.spring.basicspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring"})
@EnableScheduling
@EnableAspectJAutoProxy
public class BasicspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicspringApplication.class, args);
		System.out.println("Basic spring application started");
	}

}
