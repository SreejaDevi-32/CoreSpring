package com.example.taskmanager;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.taskmanager.model.User;

@Component
public class UserDTOMapper implements Function<User,UserDTO> {

	@Override
	public UserDTO apply(User user) {
		List<String> roles = user.getAuthorities()
	            .stream()
	            .map(GrantedAuthority::getAuthority)
	            .collect(Collectors.toList());
	    return new UserDTO(
	            user.getUsername(),
	            roles
	    );
				
	}

}
