package com.example.myBarSystemAPI.dataTransferObjects.userTypes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTypeResponse {

    private Integer id;
    private String type;
}
