package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
import com.example.myBarSystemAPI.models.Category;
import com.example.myBarSystemAPI.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

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
    void verifySaveCategoryThrowNullPointerException() {

        Assertions.assertThrows(NullPointerException.class,
                () -> categoryServiceImpl.save(null));
    }

    @Test
    void verifySaveCategoryThrowDuplicateRecordException() {
        Category category = new Category();
        String expectedMessage = String.format("Category with title:%s, is already exist", category.getTitle());

        Mockito.when(categoryServiceImpl.save(category))
                .thenThrow(DataIntegrityViolationException.class);

        DuplicateRecordException exception = Assertions.assertThrows(DuplicateRecordException.class,
                () -> categoryServiceImpl.save(category));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifySaveCategorySuccess() {
        Category category = new Category();
        categoryServiceImpl.save(category);

        Mockito.verify(categoryRepository, Mockito.times(1)).save(category);
    }

    @Test
    void verifyFindAll() {
        categoryServiceImpl.findAll();

        Mockito.verify(categoryRepository, Mockito.times(1)).findAll();
    }

    @Test
    void verifyFindByIdThrowNotFoundRecordException() {
        Integer id = 1;
        String expectedMessage = String.format("Category with id:%s, not found", id);

        NotFoundRecordException exception = Assertions.assertThrows(NotFoundRecordException.class,
                () -> categoryServiceImpl.findById(id));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifyFindByIdSuccess() {
        Integer id = 1;

        Mockito.when(categoryRepository.findById(id))
                .thenReturn(Optional.of(Category.builder()
                        .id(id)
                        .build()));

        categoryServiceImpl.findById(id);
        Mockito.verify(categoryRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void verifyFindByTitleThrowNotFoundRecordException() {
        String title = "Alcoholics";
        String expectedMessage = String.format("Category with title:%s, not found", title);

        NotFoundRecordException exception = Assertions.assertThrows(NotFoundRecordException.class,
                ()-> categoryServiceImpl.findByTitle(title));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifyFindByTitleSuccess() {
        String title = "Alcoholics";

        Mockito.when(categoryRepository.findByTitle(title))
                .thenReturn(Optional.of(Category.builder()
                        .title(title)
                        .build()));

        categoryServiceImpl.findByTitle(title);
        Mockito.verify(categoryRepository, Mockito.times(1)).findByTitle(title);
    }

    @Test
    void verifyUpdateThrowNullPointerException() {
        Category category = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> categoryServiceImpl.update(category, category.getId()));
    }

    @Test
    void verifyDeleteById() {
        Integer id = 1;
        categoryServiceImpl.deleteById(id);

        Mockito.verify(categoryRepository, Mockito.times(1)).deleteById(id);
    }
}
