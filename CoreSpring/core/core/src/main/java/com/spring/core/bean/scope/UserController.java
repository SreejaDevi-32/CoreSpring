package com.spring.core.bean.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UserController {
	@Autowired
	User user;
	
	@Autowired
	EmployeeController employeeController;
	
	public UserController() {
		System.out.println("User controller created");
	}
	@PostConstruct
	public void initUserController() {
		System.out.println("User Controller bean : "+this.hashCode()+"User bean: "+user.hashCode()+" Employee Controller Bean: "+employeeController.hashCode());
	}

}
