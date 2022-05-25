package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryServiceImpl categoryServiceImpl;

    @BeforeEach
    void beforeEach() {
        categoryServiceImpl = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    void verifyFindAll() {
        categoryServiceImpl.findAll();

        Mockito.verify(categoryRepository, Mockito.times(1)).findAll();
    }
}
