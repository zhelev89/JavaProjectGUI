package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.ProductTypeConverter;
import com.example.myBarSystemAPI.dataTransferObjects.productTypes.ProductTypeResponse;
import com.example.myBarSystemAPI.dataTransferObjects.productTypes.ProductTypeSaveRequest;
import com.example.myBarSystemAPI.models.ProductType;
import com.example.myBarSystemAPI.services.ProductTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/productType")
public class ProductTypeController {

    private ProductTypeService productTypeService;
    private ProductTypeConverter productTypeConverter;

    @PostMapping
    private ResponseEntity<ProductTypeResponse> save(@RequestBody ProductTypeSaveRequest productTypeSaveRequest) {
        ProductType productType = productTypeConverter.convert(productTypeSaveRequest);
        ProductType savedProductType = productTypeService.save(productType);
        ProductTypeResponse productTypeResponse = productTypeConverter.convert(savedProductType);
        return ResponseEntity.status(HttpStatus.CREATED).body(productTypeResponse);
    }

    @GetMapping
    private ResponseEntity<List<ProductTypeResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                productTypeService.findAll().stream()
                        .map(productType -> productTypeConverter.convert(productType))
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/id/{id}")
    private ResponseEntity<ProductTypeResponse> findById(@PathVariable Integer id) {
        ProductType productType = productTypeService.findById(id);
        ProductTypeResponse productTypeResponse = productTypeConverter.convert(productType);
        return ResponseEntity.status(HttpStatus.FOUND).body(productTypeResponse);
    }

    @GetMapping(value = "/type/{type}")
    private ResponseEntity<ProductType> findByType(@PathVariable String type) {
        ProductType productType = productTypeService.findByType(type);
        ProductTypeResponse productTypeResponse = productTypeConverter.convert(productType);
        return ResponseEntity.status(HttpStatus.FOUND).body(productType);
    }

    @PutMapping
    private ResponseEntity<ProductTypeResponse> update(@RequestBody ProductType updatedProductType) {
        ProductType productType = productTypeService.update(updatedProductType, updatedProductType.getId());
        ProductTypeResponse productTypeResponse = productTypeConverter.convert(productType);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productTypeResponse);
    }

    @DeleteMapping(value = "/id/{id}")
    private ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        productTypeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    @DeleteMapping(value = "/type/{type}")
    private ResponseEntity<HttpStatus> deleteByType(@PathVariable String type) {
        productTypeService.deleteByType(type);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

}
