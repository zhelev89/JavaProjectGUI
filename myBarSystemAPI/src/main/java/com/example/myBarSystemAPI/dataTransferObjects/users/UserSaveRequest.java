package com.example.myBarSystemAPI.dataTransferObjects.users;

import lombok.Data;

@Data
public class UserSaveRequest {

    private String name;
    private String phone;
    private String pinCode;
    private String userType;
}
