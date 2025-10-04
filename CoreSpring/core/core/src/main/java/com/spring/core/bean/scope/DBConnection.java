package com.spring.core.bean.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("prod")
public class DBConnection {
	@Value("${username}")
	String username;
	
	@Value("${password}")
	String password;
	
	@PostConstruct
	public void inintDB() {
		System.out.println("Username :"+username);
		System.out.println("Password : "+password);
	}

}
