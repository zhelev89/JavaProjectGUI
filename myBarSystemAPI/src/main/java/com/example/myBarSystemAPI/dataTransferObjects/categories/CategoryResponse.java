package com.example.myBarSystemAPI.dataTransferObjects.categories;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {

    private String title;
}
