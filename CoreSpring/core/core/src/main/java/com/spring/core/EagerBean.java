package com.spring.core;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class EagerBean implements DisposableBean {

    public EagerBean() {
        System.out.println("EagerBean initialized.");
    }

    public void doSomething() {
        System.out.println("EagerBean doing something.");
    }
    
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Destroying Eager Bean");
	}
}