package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.models.Product;

import java.util.Set;

public interface ProductService {

    Product save(Product product);

    Set<Product> findAll();

    Product findById(Integer id);

    Product findByBrand(String brand);

    Product update(Product updated, Integer id);

    void deleteById(Integer id);
}
