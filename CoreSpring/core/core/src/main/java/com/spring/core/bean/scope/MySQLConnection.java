package com.spring.core.bean.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("dev")
public class MySQLConnection {
	@Value("${username}")
	String username;
	
	@Value("${password}") String password;
	
	@PostConstruct
	public void init() {
		System.out.println("Dev Username: "+username);
		System.out.println("Dev Password: "+password);
	}

}
