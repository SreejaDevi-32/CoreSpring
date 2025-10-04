package com.example.taskmanager.auth;

import com.example.taskmanager.UserDTO;
import com.example.taskmanager.model.User;

public record AuthenticationResponse (
        String token,
        String refreshToken,
        UserDTO userDTO){
}
