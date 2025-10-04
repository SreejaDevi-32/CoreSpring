package com.spring.basic.service;

import org.springframework.stereotype.Service;

import com.spring.basic.customAnnotation.MyCustomAnnotation;

@Service
public class CustomAnnotationService {
	
	@MyCustomAnnotation(value = "Custommethod", enabled = true)
	public void myMethod() {
		System.out.println("Executing my Method");
	}
	
		@MyCustomAnnotation(value = "anotherMethod")
		public void anotheMethod() {
		System.out.println("Executing Another Method");
	}

}
