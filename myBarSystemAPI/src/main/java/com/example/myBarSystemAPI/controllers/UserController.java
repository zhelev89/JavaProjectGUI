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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                userService.findAll().stream()
                        .map(user -> userConverter.convert(user))
                        .collect(Collectors.toList()));
    }
}
