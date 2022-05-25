package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.CategoryConverter;
import com.example.myBarSystemAPI.dataTransferObjects.categories.CategoryResponse;
import com.example.myBarSystemAPI.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;
    private CategoryConverter categoryConverter;

    @GetMapping
    private ResponseEntity<List<CategoryResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                categoryService.findAll().stream()
                        .map(category -> categoryConverter.convert(category))
                        .collect(Collectors.toList()));
    }
}


