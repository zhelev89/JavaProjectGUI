package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.models.Product;
import com.example.myBarSystemAPI.models.ProductType;

import java.util.Set;

public interface ProductTypeService {

    ProductType save(ProductType productType);

    Set<ProductType> findAll();

    ProductType findById(Integer id);

    ProductType findByType(String brand);

    ProductType update(ProductType updated, Integer id);

    void deleteById(Integer id);

    void deleteByType(String type);
}
