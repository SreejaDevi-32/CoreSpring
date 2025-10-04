package com.spring.core.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(value="/api")
//@Scope(value = "session",proxyMode=ScopedProxyMode.TARGET_CLASS)
@Scope(value = "application",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class EmployeeController {
	
	public EmployeeController() {
		System.out.println("EmployeeController created");
	}
	@PostConstruct
	public void init() {
		System.out.println("EmployeeController initiated : "+this.hashCode());
	}
	@GetMapping(path="/fetchUser")
	public String getUserDetails() {
		System.out.println("Fetch user details");
		return "Fetching user details";
	}
	
	@GetMapping(path="/saveUser")
	public String saveUserDetails() {
		return "Save user details";
	}

}
