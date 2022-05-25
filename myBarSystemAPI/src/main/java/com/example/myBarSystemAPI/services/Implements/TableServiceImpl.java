package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.models.Table;
import com.example.myBarSystemAPI.repositories.TableRepository;
import com.example.myBarSystemAPI.services.TableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class TableServiceImpl implements TableService {

    private TableRepository tableRepository;

    public List<Table> findAll() {
        return tableRepository.findAll();
    }

}
