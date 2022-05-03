package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
import com.example.myBarSystemAPI.models.Table;
import com.example.myBarSystemAPI.repositories.TableRepository;
import com.example.myBarSystemAPI.services.TableService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class TableServiceImpl implements TableService {

    private TableRepository tableRepository;

    public Table save(Table table) {
        try {
            Objects.requireNonNull(table);
            return tableRepository.save(table);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(String.format(
                    "Table with number %s, already exist.", table.getNumber()));
        }
    }

    public Set<Table> findAll() {
        return new HashSet<>(tableRepository.findAll());
    }

    public Table findById(Integer id) {
        return tableRepository.findById(id).orElseThrow(
                () -> new NotFoundRecordException(String.format("Table with id:%s, not found", id)));
    }

    public Table findByNumber(Integer number) {
        return tableRepository.findByNumber(number).orElseThrow(
                () -> new NotFoundRecordException(String.format("Table with number:%s, not found", number)));
    }

    public void deleteByNumber(Integer number) {
        tableRepository.deleteByNumber(number);
    }

}
