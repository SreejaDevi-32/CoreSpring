package com.spring.core.componentscan;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void registerUser(String username, String password) {
        // Business logic to register a user
        System.out.println("Registering user: " + username);
        // ... more logic ...
    }

    public void updateUser(Long userId, String newPassword) {
        // Business logic to update a user's password
        System.out.println("Updating user: " + userId);
        // ... more logic ...
    }
}