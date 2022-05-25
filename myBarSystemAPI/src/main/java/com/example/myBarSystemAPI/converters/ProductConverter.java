package com.example.myBarSystemAPI.converters;

import com.example.myBarSystemAPI.dataTransferObjects.products.ProductResponse;
import com.example.myBarSystemAPI.dataTransferObjects.products.ProductSaveRequest;
import com.example.myBarSystemAPI.models.Product;
import com.example.myBarSystemAPI.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    @Autowired
    private ProductTypeConverter productTypeConverter;

    @Autowired
    private ProductTypeService productTypeService;

    public Product convert(ProductSaveRequest productSaveRequest) {
        return Product.builder()
                .subtype(productSaveRequest.getSubtype())
                .brand(productSaveRequest.getBrand())
                .price(productSaveRequest.getPrice())
                .quantity(productSaveRequest.getQuantity())
                .productType(productTypeService.findByType(productSaveRequest.getProductType().getType()))
                .build();
    }

    public ProductResponse convert(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .subtype(product.getSubtype())
                .brand(product.getBrand())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productType(productTypeConverter.convert(product.getProductType()))
                .build();
    }
}
