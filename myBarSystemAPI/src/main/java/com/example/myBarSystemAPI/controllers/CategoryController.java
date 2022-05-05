package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.CategoryConverter;
import com.example.myBarSystemAPI.dataTransferObjects.categories.CategoryResponse;
import com.example.myBarSystemAPI.dataTransferObjects.categories.CategorySaveRequest;
import com.example.myBarSystemAPI.models.Category;
import com.example.myBarSystemAPI.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;
    private CategoryConverter categoryConverter;

    @PostMapping
    private ResponseEntity<CategoryResponse> save(@RequestBody CategorySaveRequest categorySaveRequest) {
        Category category = categoryConverter.convert(categorySaveRequest);
        Category savedCategory = categoryService.save(category);
        CategoryResponse categoryResponse = categoryConverter.convert(savedCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

    @GetMapping
    private ResponseEntity<Set<CategoryResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                categoryService.findAll().stream()
                        .map(category -> categoryConverter.convert(category))
                        .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/id/{id}")
    private ResponseEntity<CategoryResponse> findById(@PathVariable Integer id) {
        Category category = categoryService.findById(id);
        CategoryResponse categoryResponse = categoryConverter.convert(category);
        return ResponseEntity.status(HttpStatus.FOUND).body(categoryResponse);
    }

    @GetMapping(value = "/type/{type}")
    private ResponseEntity<CategoryResponse> findByType(@PathVariable String title) {
        Category category = categoryService.findByTitle(title);
        CategoryResponse categoryResponse = categoryConverter.convert(category);
        return ResponseEntity.status(HttpStatus.FOUND).body(categoryResponse);
    }

    @PutMapping
    private ResponseEntity<CategoryResponse> update(@RequestBody Category updatedCategory) {
        Category category = categoryService.update(updatedCategory, updatedCategory.getId());
        CategoryResponse categoryResponse = categoryConverter.convert(category);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryResponse);
    }

    @DeleteMapping(value = "/id/{id}")
    private ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    @DeleteMapping(value = "/type/{type}")
    private ResponseEntity<HttpStatus> deleteByType(@PathVariable String title) {
        categoryService.deleteByTitle(title);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
