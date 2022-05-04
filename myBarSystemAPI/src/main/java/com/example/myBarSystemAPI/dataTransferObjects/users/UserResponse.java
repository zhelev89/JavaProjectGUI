package com.example.myBarSystemAPI.dataTransferObjects.users;

import com.example.myBarSystemAPI.dataTransferObjects.userTypes.UserTypeResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private String phone;
    private String pinCode;
    private UserTypeResponse userType;
}
