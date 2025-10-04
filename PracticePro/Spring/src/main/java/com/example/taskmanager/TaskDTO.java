package com.example.taskmanager;

import java.time.LocalDate;

public record TaskDTO(
		Integer id,
		String title,
		String description,
		LocalDate dueDate,
		Status status,
		Priority priority
		
		) {

}
