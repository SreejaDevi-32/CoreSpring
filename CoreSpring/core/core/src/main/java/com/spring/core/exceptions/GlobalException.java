package com.spring.core.exceptions;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CustomException.class) 
	  public ResponseEntity<?>handleCustomException(CustomException ex) { 
		  Map <String, Object> response = new LinkedHashMap<>();
		  response.put("StatusName", ex.getStatus());
		  response.put("Message", ex.getMessage());
		  return  ResponseEntity.status(ex.getStatus())
				  .body(response);
	}
	/*@ExceptionHandler(CustomException.class) 
	public void handleCustomException1(CustomException e,HttpServletResponse response) throws IOException
	{
		response.sendError(e.getStatus().value(),e.getMessage());
	} */

}
