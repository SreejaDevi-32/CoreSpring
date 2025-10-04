package com.example.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Category;
import com.example.taskmanager.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	@Transactional
	public Category createCatgeory(Category category)
	{
		return categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories()
	{
		return categoryRepository.findAll();
	}

}
