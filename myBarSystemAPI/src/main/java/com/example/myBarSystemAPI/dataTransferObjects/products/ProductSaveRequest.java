package com.example.myBarSystemAPI.dataTransferObjects.products;

import com.example.myBarSystemAPI.models.ProductType;
import lombok.Data;

@Data
public class ProductSaveRequest {

    private String subtype;
    private String brand;
    private double price;
    private double quantity;
    private ProductType productType;
}
