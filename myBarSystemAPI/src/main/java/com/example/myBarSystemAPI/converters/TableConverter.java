package com.example.myBarSystemAPI.converters;

import com.example.myBarSystemAPI.dataTransferObjects.tables.TableResponse;
import com.example.myBarSystemAPI.dataTransferObjects.tables.TableSaveRequest;
import com.example.myBarSystemAPI.models.Table;
import org.springframework.stereotype.Component;

@Component
public class TableConverter {

    public Table convert(TableSaveRequest tableSaveRequest) {
        return Table.builder()
                .number(tableSaveRequest.getNumber())
                .build();
    }

    public TableResponse convert(Table table) {
        return TableResponse.builder()
                .id(table.getId())
                .number(table.getNumber())
                .build();
    }
}
