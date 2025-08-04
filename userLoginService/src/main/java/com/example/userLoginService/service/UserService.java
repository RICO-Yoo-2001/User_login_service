package com.example.userLoginService.service;

import com.example.userLoginService.dto.LoginRequest;
import com.example.userLoginService.dto.LoginResponse;
import com.example.userLoginService.dto.SignupRequest;

public interface UserService {

    void signup(SignupRequest request);

    LoginResponse login(LoginRequest request);

    void resetPassword(String username);
}
