package com.example.userLoginService.impl;

import com.example.userLoginService.dto.LoginRequest;
import com.example.userLoginService.dto.LoginResponse;
import com.example.userLoginService.dto.SignupRequest;
import com.example.userLoginService.entity.User;
import com.example.userLoginService.mapper.UserMapper;
import com.example.userLoginService.repository.UserRepository;
import com.example.userLoginService.service.UserService;
import com.example.userLoginService.utils.JwtUtil;
import com.example.userLoginService.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void signup(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = UserMapper.toEntity(request);
        user.setPassword(PasswordUtil.encodePassword(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByUsernameOrEmail(
                request.getUsernameOrEmail(),
                request.getUsernameOrEmail());

        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = userOpt.get();

        if (!PasswordUtil.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new LoginResponse(token, user.getUsername());
    }

    @Override
    public void resetPassword(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPassword(PasswordUtil.encodePassword("default123"));
        userRepository.save(user);
    }
}
