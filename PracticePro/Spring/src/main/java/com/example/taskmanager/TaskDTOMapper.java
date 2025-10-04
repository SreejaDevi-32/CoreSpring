package com.example.taskmanager;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Task;

@Service
public class TaskDTOMapper implements Function<Task,TaskDTO>{

	@Override
	public TaskDTO apply(Task tasks) {
		// TODO Auto-generated method stub
		return new TaskDTO(
				tasks.getId(),
				tasks.getTitle(),
				tasks.getDescription(),
				tasks.getDueDate(),
				tasks.getStatus(),
				tasks.getPriority()
				);
	}

}
