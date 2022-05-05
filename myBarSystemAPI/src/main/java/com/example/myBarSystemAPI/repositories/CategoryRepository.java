package com.example.myBarSystemAPI.repositories;

import com.example.myBarSystemAPI.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
