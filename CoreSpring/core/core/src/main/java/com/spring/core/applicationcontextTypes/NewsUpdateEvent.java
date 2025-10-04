package com.spring.core.applicationcontextTypes;

import org.springframework.context.ApplicationEvent;

public class NewsUpdateEvent extends ApplicationEvent{
	public String newMessage;

	public NewsUpdateEvent(Object source,String newMessage) {
		super(source);
		// TODO Auto-generated constructor stub
		this.newMessage = newMessage;
	}
	public String getNewMessage() {
		return newMessage;
	}

}
