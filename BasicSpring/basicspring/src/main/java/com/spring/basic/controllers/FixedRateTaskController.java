package com.spring.basic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basic.classes.SimpleTask;
import com.spring.basicspring.schedulers.FixedRateSchedulerService;

@RestController
@RequestMapping("/api/fixed-rate")
public class FixedRateTaskController {
	
	@Autowired
	private FixedRateSchedulerService fixedService;
	
	@PostMapping("/schedule")
	public ResponseEntity<String> scheduleFixedRate(@RequestParam String name,@RequestParam long startTime,long interval)
	{
		try
		{
		SimpleTask simpleTask = new SimpleTask(name);
		fixedService.scheduledFixedRateTask(interval,startTime, simpleTask);
		return ResponseEntity.ok("Scheduled Fixed Rate Task "+ name + "At Interval "+interval);
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body("Failed to Schedule Task "+e.getMessage());
		}
				
	}
	
	@PostMapping("/stop")
	public ResponseEntity<String> stopFixedRate()
	{
		fixedService.stopFixedRateTask();
		return ResponseEntity.ok("Stopped Fixed Rate Task");
	}
	

}
