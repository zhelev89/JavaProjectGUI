package com.example.myBarSystemAPI.dataTransferObjects.users;

import com.example.myBarSystemAPI.models.UserType;
import lombok.Data;

@Data
public class UserSaveRequest {

    private String name;
    private String phone;
    private String pinCode;
    private UserType userType;
}
