package com.spring.basic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basic.customAnnotation.CustomAnnotationReader;
import com.spring.basic.service.LogCustomAnnotationService;

@RestController
@RequestMapping("/customAnno")
public class CustomAnnotController {
	
	@Autowired
	private LogCustomAnnotationService customAnnotationService;
	
	@Autowired
	private CustomAnnotationReader customAnnotationReader;
	
	@GetMapping("/test")
	public String test() throws InterruptedException {
		
		customAnnotationService.doSomething();
		return "Custom Annotation Done";
		
	}
	
	@GetMapping("/annotDetails")
	public String annotDetails() throws Exception {
		customAnnotationReader.annotationReader();
		return "Custom Annotation Details Fetched ";
	}
	

}
