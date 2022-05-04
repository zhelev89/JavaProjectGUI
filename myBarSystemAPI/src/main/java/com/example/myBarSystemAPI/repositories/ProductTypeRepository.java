package com.example.myBarSystemAPI.repositories;

import com.example.myBarSystemAPI.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

    Optional<ProductType> findByType(String type);
    void deleteByType(String type);
}
