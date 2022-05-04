package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.UserTypeConverter;
import com.example.myBarSystemAPI.dataTransferObjects.userTypes.UserTypeResponse;
import com.example.myBarSystemAPI.dataTransferObjects.userTypes.UserTypeSaveRequest;
import com.example.myBarSystemAPI.models.UserType;
import com.example.myBarSystemAPI.services.UserTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/userTypes")
public class UserTypeController {

    private UserTypeService userTypeService;
    private UserTypeConverter userTypeConverter;

    @PostMapping
    private ResponseEntity<UserTypeResponse> save(@RequestBody UserTypeSaveRequest userTypeSaveRequest) {
        UserType userType = userTypeConverter.convert(userTypeSaveRequest);
        UserType savedUserType = userTypeService.save(userType);
        UserTypeResponse userTypeResponse = userTypeConverter.convert(savedUserType);
        return ResponseEntity.status(HttpStatus.CREATED).body(userTypeResponse);
    }

    @GetMapping
    private ResponseEntity<Set<UserTypeResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                userTypeService.findAll().stream()
                        .map(userType -> userTypeConverter.convert(userType))
                        .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/id/{id}")
    private ResponseEntity<UserTypeResponse> findById(@PathVariable Integer id) {
        UserType userType = userTypeService.findById(id);
        UserTypeResponse userTypeResponse = userTypeConverter.convert(userType);
        return ResponseEntity.status(HttpStatus.FOUND).body(userTypeResponse);
    }

    @GetMapping(value = "/type/{type}")
    private ResponseEntity<UserTypeResponse> findByType(@PathVariable String type) {
        UserType userType = userTypeService.findByType(type);
        UserTypeResponse userTypeResponse = userTypeConverter.convert(userType);
        return ResponseEntity.status(HttpStatus.FOUND).body(userTypeResponse);
    }

    @PutMapping
    private ResponseEntity<UserTypeResponse> update(@RequestBody UserType updatedUserType) {
        UserType userType = userTypeService.update(updatedUserType, updatedUserType.getId());
        UserTypeResponse userTypeResponse = userTypeConverter.convert(userType);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userTypeResponse);
    }

    @DeleteMapping(value = "/id/{id}")
    private ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        userTypeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    @DeleteMapping(value = "/type/{type}")
    private ResponseEntity<HttpStatus> deleteByType(@PathVariable String type) {
        userTypeService.deleteByType(type);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

}
