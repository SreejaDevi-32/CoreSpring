package com.example.taskmanager.model;

import java.time.LocalDate;

import com.example.taskmanager.Priority;
import com.example.taskmanager.Status;

import jakarta.persistence.*;


@Entity
@Table(name = "Task")
public class Task {
	
	@Id
	@SequenceGenerator(name="tasks_id_seq",sequenceName="tasks_id_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tasks_id_seq")
	private int Id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private LocalDate dueDate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;
	
	@ManyToOne
	private Category category;

	public Task() {
		super();
	}

	
	public Task(int id, String title, String description, LocalDate dueDate, Status status, Priority priority) {
		super();
		Id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
		this.priority = priority;
	}


	public Task(int id, String title, String description, LocalDate dueDate, Status status, Priority priority, User user,
			Category category) {
		super();
		Id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
		this.priority = priority;
		this.user = user;
		this.category = category;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

	
	

}
