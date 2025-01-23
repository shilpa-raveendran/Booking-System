package com.example.user_management.controller;

import com.example.user_management.dto.UserDTO;
import com.example.user_management.entity.User;
import com.example.user_management.mapper.UserMapper;
import com.example.user_management.service.UserService;
import com.example.user_management.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking-portal/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            User user = userMapper.toUser(userDTO); // Map DTO to entity
            UserDTO savedUserDTO = userService.registerUser(user);
            return ResponseEntity.ok(savedUserDTO); // Return DTO
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/getAllUsers")
    public String getALlUsers(){
        return "Hello";
    }
}
