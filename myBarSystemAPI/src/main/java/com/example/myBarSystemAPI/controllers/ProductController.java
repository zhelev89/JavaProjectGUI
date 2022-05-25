package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.ProductConverter;
import com.example.myBarSystemAPI.dataTransferObjects.products.ProductResponse;
import com.example.myBarSystemAPI.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private ProductConverter productConverter;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                productService.findAll().stream()
                        .map(product -> productConverter.convert(product))
                        .collect(Collectors.toList()));
    }
}
