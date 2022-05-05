package com.example.myBarSystemAPI.dataTransferObjects.categories;

import com.example.myBarSystemAPI.models.ProductType;
import lombok.Data;

@Data
public class CategorySaveRequest {

    private ProductType productType;
    private String title;
}
