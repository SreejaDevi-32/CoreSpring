package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.TaskDTO;
import com.example.taskmanager.TaskUpdateRequest;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
	
	private TaskService taskService;
	
	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	@PostMapping
	public Task  createTask(@RequestBody Task task)
	{
		return taskService.createTask(task);
	}
	
	@PutMapping("{taskId}")
	public Task updateTask(@PathVariable("taskId") Integer taskId,@RequestBody TaskUpdateRequest taskUpdateRequest)
	{
		return taskService.updateTask(taskId, taskUpdateRequest);
	}

	@GetMapping
	public ResponseEntity<List<TaskDTO>> getAllTasks()
	{
		List<TaskDTO> tasks = taskService.getAllTasks();
		return ResponseEntity.ok(tasks);
	}
	
	@GetMapping("{taskId}")
	public ResponseEntity<TaskDTO> getTaskById(@PathVariable("taskId") Integer taskId) {
	    return taskService.getTask(taskId)
	                      .map(ResponseEntity::ok)
	                      .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
	

}
