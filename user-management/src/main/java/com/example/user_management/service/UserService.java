package com.example.user_management.service;

import com.example.user_management.dto.UserDTO;
import com.example.user_management.entity.User;

import java.util.Optional;

public interface UserService {
    UserDTO registerUser(User user);
    Optional<User> findByUsername(String username);
}
