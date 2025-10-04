package com.example.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanager.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
	
	boolean existsTaskByTitle(String title);
	List<Task> findByUserId(Long userId);
}
