package com.example.myBarSystemAPI.repositories;

import com.example.myBarSystemAPI.models.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    Optional<UserType> findByType(String type);
    void deleteByType(String type);

}
