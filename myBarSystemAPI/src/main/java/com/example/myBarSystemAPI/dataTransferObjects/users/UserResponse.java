package com.example.myBarSystemAPI.dataTransferObjects.users;

import com.example.myBarSystemAPI.models.UserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String name;
    private String phone;
    private String pinCode;
    private UserType userType;
}
