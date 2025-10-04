package com.example.taskmanager.controller;



import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.jwt.JWTUtil;
import com.example.taskmanager.model.User;
import com.example.taskmanager.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	public final UserService userService;
	public final JWTUtil jwtUtil;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
		this.jwtUtil = new JWTUtil();
	}
	
	@PostMapping
	public ResponseEntity<?>registerUser(@RequestBody User user){
		userService.createUser(user);
		String jwtToken = jwtUtil.issueToken(user.getUsername(), 1000,user.getRole().name());
		return ResponseEntity.ok()
		        .header(HttpHeaders.AUTHORIZATION, jwtToken)
		        .build();

	}
	
	
	@PutMapping("{userId}")
	public User updateUser(@PathVariable("userId") Integer userId, @RequestBody User user)
	{
		return userService.updateUser(userId, user);
	}
	
	@GetMapping
	public List<User> getUsers()
	{
		return userService.getAllUser();
	}
	
	@DeleteMapping("{userId}")
	public ResponseEntity deleteUser(@PathVariable("userId") Integer userId)
	{
		userService.deleteUser(userId);
		return ResponseEntity.ok()
				.body("Succesffuly Deleted"+userId);
	}
	

}
