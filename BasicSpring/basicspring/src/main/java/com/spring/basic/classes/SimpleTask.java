package com.spring.basic.classes;

import java.time.LocalTime;

public class SimpleTask implements Runnable{
	private  String name ;
	
	public SimpleTask (String name)
	{
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("[ "+  name + "] running at "+LocalTime.now());
	}

}
