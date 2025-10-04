package com.spring.basicspring.schedulers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import org.springframework.scheduling.support.CronTrigger;

import java.time.Instant;
import java.util.Date;

@Service
@ComponentScan(basePackages= {"com.spring.basic"})
public class DynamicSchedulerService {
	
	@Autowired
	private TaskScheduler taskScheduler;
	
	private ScheduledFuture<?> scheduledTask;
	private ScheduledFuture<?> scheduledOnce;
	public void scheduleTask(String cronExpression, Runnable task) {
	    if (scheduledTask != null) {
	        scheduledTask.cancel(true); // Cancel previous task
	    }

	    scheduledTask = taskScheduler.schedule(task, new CronTrigger(cronExpression));
	    System.out.println("Task scheduled with cron: " + cronExpression + " at " + new Date());
	}
	
	public void stopTask() {
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
            System.out.println("Task stopped.");
            scheduledTask = null;
        } else { 
            System.out.println("No task is currently scheduled.");
        }
    }
	
	public void scheduleOnce(Runnable task1)
	{
		Instant startTime = Instant.now().plusSeconds(10);
		if(scheduledOnce!= null)
		{
			scheduledOnce.cancel(true);
		}
		scheduledOnce = taskScheduler.schedule(task1, startTime);
		System.out.println("Task executed at: " + new Date());
	}

}
