package com.spring.basicspring.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderScheduler {
	
	@GetMapping("/testOrder")
	//@Scheduled(fixedRate = 2000)
	public String testOrder() {
		
		System.out.println("Sample Test Order");
		return "Sample Test Order";
	} 
	
	
	public void runTask() {
		System.out.println("Scheduled for 5 seconds");
	}

}
