package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
