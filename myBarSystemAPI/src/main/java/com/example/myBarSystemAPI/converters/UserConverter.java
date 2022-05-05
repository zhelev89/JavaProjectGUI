package com.example.myBarSystemAPI.converters;

import com.example.myBarSystemAPI.dataTransferObjects.users.UserResponse;
import com.example.myBarSystemAPI.dataTransferObjects.users.UserSaveRequest;
import com.example.myBarSystemAPI.models.User;
import com.example.myBarSystemAPI.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private UserTypeService userTypeService;

    @Autowired
    private UserTypeConverter userTypeConverter;

    public User convert(UserSaveRequest userSaveRequest) {
        return User.builder()
                .name(userSaveRequest.getName())
                .phone(userSaveRequest.getPhone())
                .pinCode(userSaveRequest.getPinCode())
                .userType(userTypeService.findByType(userSaveRequest.getUserType()))
                .build();
    }

    public UserResponse convert(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .phone(user.getPhone())
                .pinCode(user.getPinCode())
                .userType(userTypeConverter.convert(user.getUserType()))
                .build();
    }
}
