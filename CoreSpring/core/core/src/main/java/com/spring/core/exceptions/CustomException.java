package com.spring.core.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException  extends RuntimeException {
	//HttpStatus status
	HttpStatus status ;
	String message;
	public CustomException(HttpStatus badRequest, String message) {
		super();
		this.status = badRequest;
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}

	
	


