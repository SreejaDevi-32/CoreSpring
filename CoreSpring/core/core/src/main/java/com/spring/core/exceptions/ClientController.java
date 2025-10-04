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
@RequestMapping("/clients")
public class ClientController {
	
	
	@GetMapping("/getClient/{name}")
	public  ResponseEntity<?> getClient(@PathVariable  String name) throws CustomException{
		System.out.println(name);
		if(!name.equals("sreeja"))
		{
		
			throw new CustomException(HttpStatus.BAD_REQUEST, "Url is not correct");
		}
		else 
		{
			return ResponseEntity.status(HttpStatus.OK)
								.body("Correct url");
		}	
		
	}
	/*//Handling the exception manually
	  @ExceptionHandler(CustomException.class) 
	  public ResponseEntity<?>handleCustomException(CustomException ex) { 
		  Map <String, Object> response = new LinkedHashMap<>();
		  response.put("StatusName", ex.getStatus());
		  response.put("Message", ex.getMessage());
		  return  ResponseEntity.status(ex.getStatus())
				  .body(response);*/
	
}

//DefaultErrorAttribute
	