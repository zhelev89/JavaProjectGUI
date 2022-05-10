package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.models.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findById(Integer id);

    User findByName(String name);

    User update(User updated, Integer id);

    void deleteById(Integer id);
}
