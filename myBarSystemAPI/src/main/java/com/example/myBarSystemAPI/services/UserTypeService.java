package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.models.UserType;

import java.util.List;
import java.util.Set;

public interface UserTypeService {

    UserType save(UserType userType);

    List<UserType> findAll();

    UserType findById(Integer id);

    UserType findByType(String name);

    UserType update(UserType updatedUserType, Integer id);

    void deleteById(Integer id);

    void deleteByType(String type);
}
