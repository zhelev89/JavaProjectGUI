package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
import com.example.myBarSystemAPI.models.Category;
import com.example.myBarSystemAPI.repositories.CategoryRepository;
import com.example.myBarSystemAPI.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        Objects.requireNonNull(category);
        try {
            return categoryRepository.save(category);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("Category with title:%s, is already exist", category.getTitle()));
        }
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Integer id) {
        Objects.requireNonNull(id);
        return categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundRecordException(
                        String.format("Category with id:%s, not found", id)));
    }

    public Category findByTitle(String title) {
        Objects.requireNonNull(title);
        return categoryRepository.findByTitle(title).orElseThrow(
                () -> new NotFoundRecordException(
                        String.format("Category with title:%s, not found", title)));
    }

    public Category update(Category updatedCategory, Integer id) {
        Objects.requireNonNull(updatedCategory);
        Objects.requireNonNull(id);

        Category selectedCategory = findById(id);
        selectedCategory.setTitle(updatedCategory.getTitle());
        return selectedCategory;
    }

    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

    public void deleteByTitle(String title) {
        categoryRepository.deleteByTitle(title);
    }
}
