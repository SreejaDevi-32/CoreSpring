package com.example.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanager.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{
	

}
