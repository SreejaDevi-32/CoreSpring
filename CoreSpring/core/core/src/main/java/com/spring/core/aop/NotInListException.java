package com.spring.core.aop;

import org.springframework.http.HttpStatus;

public class NotInListException extends Exception {
	HttpStatus status;
	String message;
	public NotInListException(HttpStatus status, String message) {
		super();
		this.status = status;
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
