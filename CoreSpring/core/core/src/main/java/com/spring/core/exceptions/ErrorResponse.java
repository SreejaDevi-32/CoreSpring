package com.spring.core.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	private Date timestamp;
	private String msg;
	private int status;
	
	public ErrorResponse(Date timestamp, String msg, int status) {
		super();
		this.timestamp = timestamp;
		this.msg = msg;
		this.status = status;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	

}
