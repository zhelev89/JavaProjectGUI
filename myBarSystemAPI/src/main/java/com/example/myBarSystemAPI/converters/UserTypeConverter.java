package com.example.myBarSystemAPI.converters;

import com.example.myBarSystemAPI.dataTransferObjects.userTypes.UserTypeResponse;
import com.example.myBarSystemAPI.dataTransferObjects.userTypes.UserTypeSaveRequest;
import com.example.myBarSystemAPI.models.UserType;
import org.springframework.stereotype.Component;

@Component
public class UserTypeConverter {

    public UserType convert(UserTypeSaveRequest userTypeSaveRequest) {
        return UserType.builder()
                .type(userTypeSaveRequest.getType())
                .build();
    }

    public UserTypeResponse convert(UserType userType) {
        return UserTypeResponse.builder()
                .id(userType.getId())
                .type(userType.getType())
                .build();
    }
}
