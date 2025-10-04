package com.example.taskmanager.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.TaskDTO;
import com.example.taskmanager.TaskDTOMapper;
import com.example.taskmanager.TaskDao;
import com.example.taskmanager.TaskUpdateRequest;
import com.example.taskmanager.exceptions.ResourceNotFoundException;
import com.example.taskmanager.model.Task;

import jakarta.transaction.Transactional;

@Service
public class TaskService {
	
	private final TaskDao taskDao;
	private final TaskDTOMapper taskDTOMapper;
	
	public TaskService(TaskDao taskDao, TaskDTOMapper taskDTOMapper) {
		super();
		this.taskDao = taskDao;
		this.taskDTOMapper = taskDTOMapper;
	}
	
	@Transactional
	 public Task createTask(Task task) {
	        return taskDao.createTask(task);
	    }
	 
	
	@Transactional
	 public Task updateTask(Integer taskId,TaskUpdateRequest updateRequest)
	 {
		 Task taskOutput = taskDao.getTasksById(taskId)
					.map(task -> {
                    task.setTitle(updateRequest.title());
                    task.setDescription(updateRequest.description());
                    task.setDueDate(updateRequest.dueDate());
                    task.setStatus(updateRequest.status());
                    task.setPriority(updateRequest.priority());
                    task.setCategory(updateRequest.category());
					return  taskDao.updateTask(task);
					
                 }).orElseThrow(() -> new RuntimeException("Task not found with id " + taskId));
		
			return taskOutput;	 
	 }
	 
	public List<TaskDTO> getAllTasks(){
		return taskDao.getAllTasks()
				.stream()
				.map(taskDTOMapper)
				.collect(Collectors.toList());
	}
	
		public Optional<TaskDTO> getTask(Integer id)
		{
			return Optional.of(taskDao.getTasksById(id)
					.map(taskDTOMapper)
					.orElseThrow(() -> new ResourceNotFoundException(
	                        "Task with id [%s] not found".formatted(id)
	                        )));
		}
	
		@Transactional
	 public void deleteTaskById(Integer customerId) {
	        
	        taskDao.deleteTaskById(customerId);
	    }
	 
	 
	  
	
	
	
	
	

}
