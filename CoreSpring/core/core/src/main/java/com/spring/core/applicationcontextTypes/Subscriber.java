package com.spring.core.applicationcontextTypes;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriber implements ApplicationListener<NewsUpdateEvent>{

	@Override
	public void onApplicationEvent(NewsUpdateEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Subscriber received news: "+event.getNewMessage());
	}

}
