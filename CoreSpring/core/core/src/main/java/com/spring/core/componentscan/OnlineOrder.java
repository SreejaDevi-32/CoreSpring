package com.spring.core.componentscan;

import org.springframework.stereotype.Component;


public class OnlineOrder implements Order{
	public OnlineOrder() {
		System.out.println("Online order Initialized ");
	}

	@Override
	public void createOrder() {
		// TODO Auto-generated method stub
		System.out.println("create Online order");
	}

}
