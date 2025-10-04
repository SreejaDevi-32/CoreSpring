package com.example.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.taskmanager.TaskDao;
import com.example.taskmanager.exceptions.ResourceNotFoundException;
import com.example.taskmanager.model.Category;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.CategoryRepository;
import com.example.taskmanager.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskJPADataAccessService implements TaskDao{
	
	private final TaskRepository taskRepo;
	private final CategoryRepository categoryRepository;
	
	public TaskJPADataAccessService(TaskRepository taskRepo,CategoryRepository categoryRepository) {
		this.taskRepo = taskRepo;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		Page<Task> page = taskRepo.findAll(Pageable.ofSize(3));
		return page.getContent();
	}

	@Override
	public Optional<Task> getTasksById(Integer id) {
		return taskRepo.findById(id);
	}

	 @Override
	 @Transactional
	    public Task createTask(Task task) {
		 // Validate and fetch the existing Category
		    Integer categoryId = task.getCategory().getId().intValue();
		    Category category = categoryRepository.findById(categoryId)
		            .orElseThrow(() -> new ResourceNotFoundException("Category with id " + categoryId + " not found"));

		    // Attach the existing Category entity
		    task.setCategory(category);

		    return taskRepo.save(task);
	    }

	

	@Override
	@Transactional
	public void deleteTaskById(Integer id) {
		// TODO Auto-generated method stub
		taskRepo.deleteById(id);
		
	}

	@Override
	@Transactional
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		
		
		 return taskRepo.save(task);
		
	}


}
