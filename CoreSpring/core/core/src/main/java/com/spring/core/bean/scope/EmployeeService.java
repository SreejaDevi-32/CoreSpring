package com.spring.core.bean.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class EmployeeService {
	
	@Autowired(required = true)
	User user;
	public EmployeeService() {
		System.out.println("Employee service Bean Created(Singleton)");
	}
	public void processEmployeeData() {
		System.out.println("Processing Employee Data");
	}
	@PostConstruct
	public void initEmployeeService() {
		System.out.println("Employee service bean: "+this.hashCode()+"User bean: "+user.hashCode());
	}
	
}
