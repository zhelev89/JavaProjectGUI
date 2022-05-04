package com.example.myBarSystemAPI.dataTransferObjects.productTypes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductTypeResponse {

    private Integer id;
    private String type;
}
