package com.example.taskmanager.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.taskmanager.UserDTO;
import com.example.taskmanager.UserDTOMapper;
import com.example.taskmanager.jwt.JWTUtil;
import com.example.taskmanager.model.User;

@Service
public class AuthenticationService {
	 private final AuthenticationManager authenticationManager;
	    private final UserDTOMapper userDTOMapper;
	    private final JWTUtil jwtUtil;

	    public AuthenticationService(AuthenticationManager authenticationManager,
	    		UserDTOMapper userDTOMapper,
	                                 JWTUtil jwtUtil) {
	        this.authenticationManager = authenticationManager;
	        this.userDTOMapper = userDTOMapper;
	        this.jwtUtil = jwtUtil;
	    }

	    public AuthenticationResponse login(AuthenticationRequest request) {
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        request.username(),
	                        request.password()
	                )
	        );
	        User principal = (User) authentication.getPrincipal();
	        UserDTO userDTO = userDTOMapper.apply(principal);
	        String token = jwtUtil.issueToken(userDTO.username(),60000, userDTO.roles());
	        String refreshToken = jwtUtil.issueToken(userDTO.username(),180000, userDTO.roles());
	        return new AuthenticationResponse(token,refreshToken, userDTO);
	    }


}

