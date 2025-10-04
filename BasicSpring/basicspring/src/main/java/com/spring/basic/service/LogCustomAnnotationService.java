package com.spring.basic.service;

import org.springframework.stereotype.Service;

import com.spring.basic.customAnnotation.LogExecutionTime;

@Service
public class LogCustomAnnotationService {
	
	@LogExecutionTime
	public void doSomething() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Doing custom Annotation work.....");
	}

}
