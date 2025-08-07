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

    public String getUsername() { return username; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getNic() { return nic; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }
}

