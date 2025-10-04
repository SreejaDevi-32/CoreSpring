package com.spring.basicspring.schedulers;

import java.time.Duration;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages= {"com.spring.basic"})
public class FixedRateSchedulerService {
	
	
	@Autowired
	private TaskScheduler fixedtaskScheduler;
	
	private ScheduledFuture<?> schedulerFuture;
	
	public void scheduledFixedRateTask(long startTimeSeconds,long intervalSeconds,Runnable task)
	{
		if(schedulerFuture!=null)
		{
			schedulerFuture.cancel(true);
		}
		Duration interval = Duration.ofSeconds(intervalSeconds);
		schedulerFuture = fixedtaskScheduler.scheduleAtFixedRate(task, interval);
		System.out.println("Scheduled at Fixed Rate at Interval  "+interval);
	}
	
	public void stopFixedRateTask()
	{
		if(schedulerFuture!= null)
		{
			schedulerFuture.cancel(true);
			System.out.println("Fixed Rate Scheduler Stopped");
			schedulerFuture = null;
		}
		else 
		{
			System.out.println("No Scheduler is running");
		}
	}
}
