package com.spring.core;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // Enable lazy initialization for this bean
class LazyBean {

    public LazyBean() {
        System.out.println("LazyBean initialized.");
    }

    public void doSomething() {
        System.out.println("LazyBean doing something.");
    }
}