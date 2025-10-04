package com.example.taskmanager;

import java.util.List;

public record UserDTO(
		 String username,
		 List<String> roles	
		){	

}
