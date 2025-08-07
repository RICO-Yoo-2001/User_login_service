package com.example.userLoginService.mapper;

import com.example.userLoginService.dto.SignupRequest;
import com.example.userLoginService.entity.User;

public class UserMapper {

    public static User toEntity(SignupRequest dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setNic(dto.getNic());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // encrypt later in service
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }
}
