package com.example.myBarSystemAPI.converters;

import com.example.myBarSystemAPI.dataTransferObjects.products.ProductResponse;
import com.example.myBarSystemAPI.dataTransferObjects.products.ProductSaveRequest;
import com.example.myBarSystemAPI.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product convert(ProductSaveRequest productSaveRequest) {
        return Product.builder()
                .subtype(productSaveRequest.getSubtype())
                .brand(productSaveRequest.getBrand())
                .price(productSaveRequest.getPrice())
                .quantity(productSaveRequest.getQuantity())
                .productType(productSaveRequest.getProductType())
                .build();
    }

    public ProductResponse convert(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .subtype(product.getSubtype())
                .brand(product.getBrand())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productType(product.getProductType())
                .build();
    }
}
