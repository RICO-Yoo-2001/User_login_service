package com.example.userLoginService.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.userLoginService.dto.LoginRequest;
import com.example.userLoginService.dto.LoginResponse;
import com.example.userLoginService.dto.SignupRequest;

public interface UserService {

    void signup(SignupRequest request);

    LoginResponse login(LoginRequest request);

    void resetPassword(String username);

    UserDetails loadUserByUsername(String username);

    String registerUser(SignupRequest signupRequest);

    LoginResponse loginUser(LoginRequest loginRequest);
}
