package com.example.myBarSystemAPI.repositories;

import com.example.myBarSystemAPI.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByBrand(String brand);
}
