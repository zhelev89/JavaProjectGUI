package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.models.ProductType;

import java.util.List;

public interface ProductTypeService {

    ProductType save(ProductType productType);

    List<ProductType> findAll();

    ProductType findById(Integer id);

    ProductType findByType(String brand);

    ProductType update(ProductType updated, Integer id);

    void deleteById(Integer id);

    void deleteByType(String type);
}
