package com.spring.basic.Exceptions;

import org.springframework.http.HttpStatus;

public class ZeroCustomException extends Throwable{
	
	private static final long serialVersionUID = 1L;
	HttpStatus status;
	String message;
	public ZeroCustomException(HttpStatus status, String message) {
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
