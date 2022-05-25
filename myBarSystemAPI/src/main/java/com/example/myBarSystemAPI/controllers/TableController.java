package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.TableConverter;
import com.example.myBarSystemAPI.dataTransferObjects.tables.TableResponse;
import com.example.myBarSystemAPI.services.TableService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/tables")
public class TableController {

    private TableService tableService;

    private TableConverter tableConverter;

    @GetMapping
    public ResponseEntity<List<TableResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(
                tableService.findAll().stream()
                        .map(table -> tableConverter.convert(table))
                        .collect(Collectors.toList()));
    }
}
