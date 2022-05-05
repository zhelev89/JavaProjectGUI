package com.example.myBarSystemAPI.repositories;

import com.example.myBarSystemAPI.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByTitle(String title);

    void deleteByTitle(String title);
}
