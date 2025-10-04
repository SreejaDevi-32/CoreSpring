package com.example.taskmanager;

import java.time.LocalDate;

import com.example.taskmanager.model.Category;

public record TaskUpdateRequest(	
		String title,
		String description,
		LocalDate dueDate,
		Status status,
		Priority priority,
		Category category
		)
{
	

}
