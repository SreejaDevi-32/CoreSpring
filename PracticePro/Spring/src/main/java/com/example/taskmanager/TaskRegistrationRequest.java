package com.example.taskmanager;

import java.time.LocalDate;

public record TaskRegistrationRequest(
		Integer id,
		String title,
		String description,
		LocalDate dueDate,
		Status status,
		Priority priority
		
		) {
	

}
