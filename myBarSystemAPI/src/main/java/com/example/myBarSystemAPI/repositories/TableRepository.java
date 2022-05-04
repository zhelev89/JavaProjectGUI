package com.example.myBarSystemAPI.repositories;

import com.example.myBarSystemAPI.models.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableRepository extends JpaRepository<Table, Integer> {

    Optional<Table> findByNumber(Integer number);

    void deleteByNumber(Integer number);
}
