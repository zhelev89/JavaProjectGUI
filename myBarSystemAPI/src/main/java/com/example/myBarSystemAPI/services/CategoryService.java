package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.models.Category;

import java.util.Set;

public interface CategoryService {

    Category save(Category category);

    Set<Category> findAll();

    Category findById(Integer id);

    Category findByTitle(String title);

    Category update(Category updatedCategory, Integer id);

    void deleteById(Integer id);

    void deleteByTitle(String title);
}
