package com.spring.core.exceptions;

import java.io.IOException;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.error.DefaultErrorAttribute;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	
	@GetMapping("/getCust/{name}")
	public  ResponseEntity<?> getClient(@PathVariable  String name) throws  CustomException1{
		System.out.println(name);
		if(!name.equals("elseaaa"))
		{
		
			throw new CustomException1(HttpStatus.BAD_REQUEST, "I like elsa");
		}
		else 
		{
			return ResponseEntity.status(HttpStatus.OK)
								.body("Correct url");
		}	
		
	}
	
	
	
}

//DefaultErrorAttribute
	