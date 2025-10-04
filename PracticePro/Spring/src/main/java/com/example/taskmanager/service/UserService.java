package com.example.taskmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	 private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional
	public User createUser(User user)
	{
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Transactional
	public User updateUser(Integer userId,User updatedUser)
	{
		return userRepository.findById(userId)
				.map(user -> {
				user.setUsername(updatedUser.getUsername());
				user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
				user.setRole(updatedUser.getRole());
				return userRepository.save(user);
				}).orElseThrow(()->new RuntimeException("User not found"));
	}
	
	public List<User> getAllUser() {
		
		
		/*
		 * return userRepository.findAll() .stream() .map(user -> {
		 * user.setPassword(passwordEncoder.decode(user.getPassword())); return user; })
		 * .collect(Collectors.toList());
		 */
		return  userRepository.findAll();
	}
	
	public Optional<User> getUserByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}
	
	@Transactional
	public void deleteUser(Integer userId)
	{
		userRepository.deleteById(userId);
	}
	
	

}
