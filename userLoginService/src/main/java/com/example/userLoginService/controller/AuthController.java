package com.example.userLoginService.controller;

import com.example.userLoginService.dto.LoginRequest;
import com.example.userLoginService.dto.LoginResponse;
import com.example.userLoginService.dto.SignupRequest;
import com.example.userLoginService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        userService.signup(request);
        return ResponseEntity.ok("Account created");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @PostMapping("/reset-password/{username}")
    public ResponseEntity<String> reset(@PathVariable String username) {
        userService.resetPassword(username);
        return ResponseEntity.ok("Password reset to default");
    }
}
