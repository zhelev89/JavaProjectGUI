package com.example.myBarSystemAPI.converters;

import com.example.myBarSystemAPI.dataTransferObjects.categories.CategoryResponse;
import com.example.myBarSystemAPI.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryResponse convert(Category category) {
        return CategoryResponse.builder()
                .title(category.getTitle())
                .build();
    }
}
