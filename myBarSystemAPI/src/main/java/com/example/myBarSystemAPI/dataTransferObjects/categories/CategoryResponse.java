package com.example.myBarSystemAPI.dataTransferObjects.categories;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {

    private Integer id;
    private String title;
}
