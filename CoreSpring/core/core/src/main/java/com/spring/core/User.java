package com.spring.core;

//import org.springframework.stereotype.Component;

public class User {
	String userName;
	String password;
	public User(String userName, String password)
	{
		this.userName=userName;
		this.password=password;
	}
	public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }                  

}
