package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.ProductConverter;
import com.example.myBarSystemAPI.dataTransferObjects.products.ProductResponse;
import com.example.myBarSystemAPI.dataTransferObjects.products.ProductSaveRequest;
import com.example.myBarSystemAPI.models.Product;
import com.example.myBarSystemAPI.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private ProductConverter productConverter;

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody ProductSaveRequest productSaveRequest) {
        Product product = productConverter.convert(productSaveRequest);
        Product savedProduct = productService.save(product);
        ProductResponse productResponse = productConverter.convert(savedProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping
    public ResponseEntity<Set<ProductResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                productService.findAll().stream()
                        .map(product -> productConverter.convert(product))
                        .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Integer id) {
        Product product = productService.findById(id);
        ProductResponse productResponse = productConverter.convert(product);
        return ResponseEntity.status(HttpStatus.FOUND).body(productResponse);
    }

    @GetMapping(value = "/brand/{brand}")
    public ResponseEntity<ProductResponse> findByName(@PathVariable String brand) {
        Product product = productService.findByBrand(brand);
        ProductResponse productResponse = productConverter.convert(product);
        return ResponseEntity.status(HttpStatus.FOUND).body(productResponse);
    }

    @PutMapping
    public ResponseEntity<ProductResponse> update(@RequestBody Product updatedProduct) {
        Product product = productService.update(updatedProduct, updatedProduct.getId());
        ProductResponse productResponse = productConverter.convert(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productResponse);
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseEntity<HttpStatus> deleteById(Integer id) {
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
