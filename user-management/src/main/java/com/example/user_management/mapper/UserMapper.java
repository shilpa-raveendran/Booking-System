package com.example.user_management.mapper;

import com.example.user_management.dto.UserDTO;
import com.example.user_management.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "role", expression = "java(user.getRole().name())")// Maps Role enum to String
    UserDTO toUserDTO(User user);

    @Mapping(target = "role", expression = "java(User.Role.valueOf(dto.getRole()))") // Maps String to Role enum
    User toUser(UserDTO dto);
}
