package com.example.myBarSystemAPI.converters;

import com.example.myBarSystemAPI.dataTransferObjects.tables.TableResponse;
import com.example.myBarSystemAPI.models.Table;
import org.springframework.stereotype.Component;

@Component
public class TableConverter {

    public TableResponse convert(Table table) {
        return TableResponse.builder()
                .number(table.getNumber())
                .build();
    }
}
