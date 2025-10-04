package com.spring.core.componentscan;

import org.springframework.stereotype.Component;


public class OfflineOrder implements Order{
	public OfflineOrder()
	{
		System.out.println("Offline Order Initialized");
	}
	@Override
	public void createOrder() {
		// TODO Auto-generated method stub
		System.out.println("Created Offline order");
		
	}

}
