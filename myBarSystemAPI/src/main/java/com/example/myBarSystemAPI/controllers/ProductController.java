package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.ProductConverter;
import com.example.myBarSystemAPI.converters.UserConverter;
import com.example.myBarSystemAPI.dataTransferObjects.users.UserResponse;
import com.example.myBarSystemAPI.dataTransferObjects.users.UserSaveRequest;
import com.example.myBarSystemAPI.models.User;
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
    public ResponseEntity<ProductRes> save(@RequestBody UserSaveRequest userSaveRequest) {
        User user = userConverter.convert(userSaveRequest);
        User savedUser = productService.save(user);
        UserResponse userResponse = userConverter.convert(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping
    public ResponseEntity<Set<UserResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                productService.findAll().stream()
                        .map(user -> userConverter.convert(user))
                        .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Integer id) {
        User user = productService.findById(id);
        UserResponse userResponse = userConverter.convert(user);
        return ResponseEntity.status(HttpStatus.FOUND).body(userResponse);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<UserResponse> findByName(@PathVariable String name) {
        User user = productService.findByName(name);
        UserResponse userResponse = userConverter.convert(user);
        return ResponseEntity.status(HttpStatus.FOUND).body(userResponse);
    }

    @PutMapping
    public ResponseEntity<UserResponse> update(@RequestBody User updatedUser) {
        User user = productService.update(updatedUser, updatedUser.getId());
        UserResponse userResponse = userConverter.convert(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userResponse);
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseEntity<HttpStatus> deleteById(Integer id) {
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
