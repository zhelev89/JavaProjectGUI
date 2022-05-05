package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.TableConverter;
import com.example.myBarSystemAPI.dataTransferObjects.tables.TableResponse;
import com.example.myBarSystemAPI.dataTransferObjects.tables.TableSaveRequest;
import com.example.myBarSystemAPI.models.Table;
import com.example.myBarSystemAPI.services.TableService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/tables")
public class TableController {

    private TableService tableService;
    private TableConverter tableConverter;

    @PostMapping
    public ResponseEntity<TableResponse> save(@RequestBody TableSaveRequest tableSaveRequest) {
        Table table = tableConverter.convert(tableSaveRequest);
        Table savedTable = tableService.save(table);
        TableResponse tableResponse = tableConverter.convert(savedTable);
        return ResponseEntity.status(HttpStatus.CREATED).body(tableResponse);
    }

    @GetMapping
    public ResponseEntity<Set<Table>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(tableService.findAll());
    }

    @GetMapping(value = "/number/{number}")
    public ResponseEntity<TableResponse> findByNumber(@PathVariable Integer number) {
        Table table = tableService.findByNumber(number);
        TableResponse tableResponse = tableConverter.convert(table);
        return ResponseEntity.status(HttpStatus.FOUND).body(tableResponse);
    }

    @DeleteMapping(value = "/number/{number}")
    public ResponseEntity<HttpStatus> deleteByNumber(@PathVariable Integer number) {
        tableService.deleteByNumber(number);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
