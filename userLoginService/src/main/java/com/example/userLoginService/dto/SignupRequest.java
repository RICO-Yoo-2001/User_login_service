package com.example.userLoginService.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String nic;
    private String email;
    private String password;
    private String phoneNumber;
}

