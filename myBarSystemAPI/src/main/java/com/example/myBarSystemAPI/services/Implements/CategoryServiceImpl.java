package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.models.Category;
import com.example.myBarSystemAPI.repositories.CategoryRepository;
import com.example.myBarSystemAPI.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
