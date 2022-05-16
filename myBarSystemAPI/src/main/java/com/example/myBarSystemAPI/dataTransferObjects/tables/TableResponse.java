package com.example.myBarSystemAPI.dataTransferObjects.tables;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TableResponse {

    private Integer id;
    private Integer number;
}
