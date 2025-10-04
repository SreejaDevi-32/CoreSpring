package com.spring.basic.controllers;

import com.spring.basic.classes.SimpleTask;
import com.spring.basicspring.schedulers.DynamicSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private DynamicSchedulerService schedulerService;

    /**
     * Schedule a new task with a cron expression.
     * @param name name of the task
     * @param cron cron expression (e.g., 0/5 * * * * * for every 5 seconds)
     * @return ResponseEntity with status
     */
    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleTask(@RequestParam String name, @RequestParam String cron) {
        try {
            SimpleTask task = new SimpleTask(name);
            schedulerService.scheduleTask(cron, task);
            return ResponseEntity.ok("Scheduled task '" + name + "' with cron: " + cron);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to schedule task: " + e.getMessage());
        }
    }

    /**
     * Stop the currently scheduled task.
     * @return ResponseEntity with status
     */
    @PostMapping("/stop")
    public ResponseEntity<String> stopTask() {
        schedulerService.stopTask();
        return ResponseEntity.ok("Stopped any running task (if any).");
    }
   
    @PostMapping("/scheduledOnce")
   public ResponseEntity<String> scheduledOnce(@RequestParam String othername)
   {
	   try {
		   SimpleTask task1 = new SimpleTask(othername);
		   schedulerService.scheduleOnce(task1);
		   return ResponseEntity.ok("Scheduled Task "+othername);
		   
	   }
	   catch(Exception e)
	   {
		   return ResponseEntity.badRequest().body("Failed to schedule task: " + e.getMessage());
	   }
   }
}
