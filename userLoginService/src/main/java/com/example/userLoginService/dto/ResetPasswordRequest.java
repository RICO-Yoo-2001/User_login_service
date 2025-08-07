package com.example.userLoginService.dto;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String usernameOrEmail;
    private String newPassword;
}
