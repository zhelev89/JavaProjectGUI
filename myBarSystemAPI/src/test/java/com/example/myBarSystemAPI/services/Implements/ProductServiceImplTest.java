package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
import com.example.myBarSystemAPI.models.Product;
import com.example.myBarSystemAPI.repositories.ProductRepository;
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
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    private ProductServiceImpl productServiceImpl;

    @BeforeEach
    void beforeEach() {
        productServiceImpl = new ProductServiceImpl(productRepository);
    }

    @Test
    void verifySaveProductThrowNullPointerException() {

        Assertions.assertThrows(NullPointerException.class,
                () -> productServiceImpl.save(null));
    }

    @Test
    void verifySaveProductThrowDuplicateRecordException() {
        Product product = new Product();
        String expectedMessage = String.format("Product with brand:%s, already exist.", product.getBrand());

        Mockito.when(productServiceImpl.save(product))
                .thenThrow(DataIntegrityViolationException.class);

        DuplicateRecordException exception = Assertions.assertThrows(DuplicateRecordException.class,
                () -> productServiceImpl.save(product));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifySaveProductSuccess() {
        Product product = new Product();
        productServiceImpl.save(product);

        Mockito.verify(productRepository, Mockito.times(1)).save(product);
    }

    @Test
    void verifyFindAll() {
        productServiceImpl.findAll();

        Mockito.verify(productRepository, Mockito.times(1)).findAll();
    }

    @Test
    void verifyFindByIdThrowNotFoundRecordException() {
        Integer id = 1;
        String expectedMessage = String.format("Product with id:%s, not found", id);

        NotFoundRecordException exception = Assertions.assertThrows(NotFoundRecordException.class,
                () -> productServiceImpl.findById(id));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifyFindByIdSuccess() {
        Integer id = 1;

        Mockito.when(productRepository.findById(id))
                .thenReturn(Optional.of(Product.builder()
                        .id(id)
                        .build()));

        productServiceImpl.findById(id);
        Mockito.verify(productRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void verifyFindByBrandThrowNotFoundRecordException() {
        String brand = "Johny Walker";
        String expectedMessage = String.format("Product with brand: %s, not found", brand);

        NotFoundRecordException exception = Assertions.assertThrows(NotFoundRecordException.class,
                ()-> productServiceImpl.findByBrand(brand));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifyFindByBrandSuccess() {
        String brand = "Johny Walker";

        Mockito.when(productRepository.findByBrand(brand))
                .thenReturn(Optional.of(Product.builder()
                        .brand(brand)
                        .build()));

        productServiceImpl.findByBrand(brand);
        Mockito.verify(productRepository, Mockito.times(1)).findByBrand(brand);
    }

    @Test
    void verifyUpdateThrowNullPointerException() {
        Product product = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> productServiceImpl.update(product, product.getId()));
    }

    @Test
    void verifyDeleteById() {
        Integer id = 1;
        productServiceImpl.deleteById(id);

        Mockito.verify(productRepository, Mockito.times(1)).deleteById(id);
    }
}
