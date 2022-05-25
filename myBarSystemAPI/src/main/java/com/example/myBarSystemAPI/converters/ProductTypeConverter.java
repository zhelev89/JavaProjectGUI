package com.example.myBarSystemAPI.converters;

import com.example.myBarSystemAPI.dataTransferObjects.productTypes.ProductTypeResponse;
import com.example.myBarSystemAPI.dataTransferObjects.productTypes.ProductTypeSaveRequest;
import com.example.myBarSystemAPI.models.ProductType;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeConverter {

    public ProductType convert(ProductTypeSaveRequest productTypeSaveRequest) {
        return ProductType.builder()
                .type(productTypeSaveRequest.getType())
                .build();
    }

    public ProductTypeResponse convert(ProductType productType) {
        return ProductTypeResponse.builder()
                .type(productType.getType())
                .build();
    }
}
