package com.example.taskmanager;

import java.util.List;
import java.util.Optional;

import com.example.taskmanager.model.Task;

public interface TaskDao {
	
	List<Task> getAllTasks();
	Optional<Task> getTasksById(Integer id);
	
	Task createTask(Task task);
	Task updateTask(Task task);
	void deleteTaskById(Integer id);

}
