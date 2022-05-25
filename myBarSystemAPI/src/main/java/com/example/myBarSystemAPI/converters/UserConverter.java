package com.example.myBarSystemAPI.converters;

import com.example.myBarSystemAPI.dataTransferObjects.users.UserResponse;
import com.example.myBarSystemAPI.dataTransferObjects.users.UserSaveRequest;
import com.example.myBarSystemAPI.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convert(UserSaveRequest userSaveRequest) {
        return User.builder()
                .name(userSaveRequest.getName())
                .pinCode(userSaveRequest.getPinCode())
                .phone(userSaveRequest.getPhone())
                .userType(userSaveRequest.getUserType())
                .build();
    }

    public UserResponse convert(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .phone(user.getPhone())
                .pinCode(user.getPinCode())
                .userType(user.getUserType())
                .build();
    }
}
