package com.example.myBarSystemAPI.dataTransferObjects.products;

import com.example.myBarSystemAPI.models.ProductType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private Integer id;
    private String subtype;
    private String brand;
    private double price;
    private double quantity;
    private ProductType productType;
}
