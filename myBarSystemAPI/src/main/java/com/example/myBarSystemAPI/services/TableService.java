package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.models.Table;

import java.util.List;
import java.util.Set;

public interface TableService {

    Table save(Table table);

    List<Table> findAll();

    Table findById(Integer id);

    Table findByNumber(Integer number);

    void deleteByNumber(Integer number);
}
