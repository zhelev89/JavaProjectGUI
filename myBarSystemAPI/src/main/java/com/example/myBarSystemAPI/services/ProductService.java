package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.models.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product findById(Integer id);

    Product findByBrand(String brand);

    Product update(Product updated, Integer id);

    void deleteById(Integer id);
}
