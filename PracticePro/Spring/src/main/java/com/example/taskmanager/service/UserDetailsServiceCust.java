package com.example.taskmanager.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceCust implements UserDetailsService{
	
	private final UserService userService;

	public UserDetailsServiceCust(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userService.getUserByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(
                        "Username " + username + " not found"));
	}
	
		

}
