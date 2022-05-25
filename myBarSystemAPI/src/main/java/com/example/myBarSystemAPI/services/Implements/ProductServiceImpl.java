package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.models.Product;
import com.example.myBarSystemAPI.repositories.ProductRepository;
import com.example.myBarSystemAPI.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
