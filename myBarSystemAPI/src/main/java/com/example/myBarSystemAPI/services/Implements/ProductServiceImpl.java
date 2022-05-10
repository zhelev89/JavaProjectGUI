package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
import com.example.myBarSystemAPI.models.Product;
import com.example.myBarSystemAPI.repositories.ProductRepository;
import com.example.myBarSystemAPI.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public Product save(Product product) {
        try {
            Objects.requireNonNull(product);
            return productRepository.save(product);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("Product with brand:%s, already exist.", product.getBrand()));
        }
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(
                () -> new NotFoundRecordException(String.format("Product with id:%s, not found", id)));
    }

    public Product findByBrand(String brand) {
        return productRepository.findByBrand(brand).orElseThrow(
                () -> new NotFoundRecordException(String.format("Product with brand: %s, not found", brand)));
    }

    public Product update(Product updated, Integer id) {
        Objects.requireNonNull(updated);
        Objects.requireNonNull(id);

        Product selectedProduct = findById(id);
        Product updatedProduct = new Product();
        selectedProduct.setSubtype(updatedProduct.getSubtype());
        selectedProduct.setBrand(updated.getBrand());
        selectedProduct.setPrice(updatedProduct.getPrice());
        selectedProduct.setQuantity(updatedProduct.getQuantity());
        selectedProduct.setProductType(updatedProduct.getProductType());
        return selectedProduct;
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
