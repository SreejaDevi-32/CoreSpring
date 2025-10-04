package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.model.Category;
import com.example.taskmanager.repository.CategoryRepository;
import com.example.taskmanager.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category)
	{
		Category savedCategory = categoryService.createCatgeory(category);
		return ResponseEntity.ok(savedCategory);
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category> categories = categoryService.getAllCategories();
		return ResponseEntity.ok(categories);
	}

}
