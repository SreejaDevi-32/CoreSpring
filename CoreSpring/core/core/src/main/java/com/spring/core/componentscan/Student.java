package com.spring.core.componentscan;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ComponentScan;

@Component
public class Student {
    public Student() {
        System.out.println("Student Bean Created");
    }
}