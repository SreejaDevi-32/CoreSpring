package com.spring.core;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Dev  implements InitializingBean,DisposableBean{
	
	//@Autowired
	private Laptop laptop; //Field Injection
	
	
	 public Dev(Laptop laptop) //Constructor Injection 
	 { 
		 this.laptop =laptop; 
		 System.out.println("Dev Class Injected Laptop Dependency");
	 }
	 @Override
		public void afterPropertiesSet() throws Exception {
			System.out.println("Initializing Dev Bean after Construct using afterPropertiesSet");
			
		}
	 @PostConstruct
	 public void initDev() {
		 System.out.println("Post Construct of Dev Bean");
	 }
	 @Override
		public void destroy() throws Exception {
			System.out.println("Disposable Dev Bean before destory using destroy");
			
		}
	 @PreDestroy
	 public void destroyDev()
	 {
		 System.out.print("Destroy Dev Bean using PreDestroy");
	 }
	@Autowired
	public void setLaptop(Laptop laptop)
	{
		this.laptop = laptop;
	}
	
	public void build() {
		laptop.compile();
		
		System.out.println("Working with Spring Boot");
	}
	

	

}
