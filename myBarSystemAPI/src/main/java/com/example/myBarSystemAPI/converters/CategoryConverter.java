package com.example.myBarSystemAPI.converters;

import com.example.myBarSystemAPI.dataTransferObjects.categories.CategoryResponse;
import com.example.myBarSystemAPI.dataTransferObjects.categories.CategorySaveRequest;
import com.example.myBarSystemAPI.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public Category convert(CategorySaveRequest categorySaveRequest) {
        return Category.builder()
                .title(categorySaveRequest.getTitle())
                .build();
    }

    public CategoryResponse convert(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .title(category.getTitle())
                .build();
    }
}
