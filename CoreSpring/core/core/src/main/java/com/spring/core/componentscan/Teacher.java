package com.spring.core.componentscan;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Teacher {
	private Student student;
	public Teacher(Student student) {
		this.student =student;
		System.out.println("Teacher bean created: "+this.hashCode()+"Student bean injected: "+student.hashCode());
		
	}	
	@RequestMapping(path="/getTeacher",method =RequestMethod.GET)
	
	public String getTeacher() {
		return "Teacher Details";
	}

}
