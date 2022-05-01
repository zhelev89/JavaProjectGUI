package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.UserConverter;
import com.example.myBarSystemAPI.dataTransferObjects.users.UserResponse;
import com.example.myBarSystemAPI.dataTransferObjects.users.UserSaveRequest;
import com.example.myBarSystemAPI.models.User;
import com.example.myBarSystemAPI.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private UserConverter userConverter;

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserSaveRequest userSaveRequest) {
        User user = userConverter.convert(userSaveRequest);
        User savedUser = userService.save(user);
        UserResponse userResponse = userConverter.convert(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping
    public ResponseEntity<Set<UserResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                userService.findAll().stream()
                        .map(user -> userConverter.convert(user))
                        .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        UserResponse userResponse = userConverter.convert(user);
        return ResponseEntity.status(HttpStatus.FOUND).body(userResponse);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<UserResponse> findByName(@PathVariable String name) {
        User user = userService.findByName(name);
        UserResponse userResponse = userConverter.convert(user);
        return ResponseEntity.status(HttpStatus.FOUND).body(userResponse);
    }

    @PutMapping
    public ResponseEntity<UserResponse> update(@RequestBody User updatedUser) {
        User user = userService.update(updatedUser, updatedUser.getId());
        UserResponse userResponse = userConverter.convert(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userResponse);
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseEntity<HttpStatus> deleteById(Integer id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
