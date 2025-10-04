package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Laptop implements Computer {
	@Autowired
	private ConfigurableBeanFactory beanFactory;
	
	
	@PostConstruct
	public void initLaptop() {
		System.out.println("Init Steps after Laptop Bean construct");
		
	}
	@PreDestroy
	public void destroyLaptop() {
		System.out.println("Destory steps after Laptop bean Destroy");
	}
	
	public void compile() {
		System.out.println("Compiling in Sreeja Laptop");
	}
	
	public void useSingletonBeanDestroy(String name,Object instance) {
		 beanFactory.destroyBean(name, instance);
		
	}
}
