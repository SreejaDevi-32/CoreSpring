package com.spring.core.applicationcontextTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class NewsAgency {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public void publishNews(String news)
	{
		NewsUpdateEvent newsUpdateEvent = new NewsUpdateEvent(this,news);
		 publisher.publishEvent(newsUpdateEvent);
	}

}
