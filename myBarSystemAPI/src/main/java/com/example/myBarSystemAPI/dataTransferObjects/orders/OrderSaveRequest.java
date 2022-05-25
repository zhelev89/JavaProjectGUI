package com.example.myBarSystemAPI.dataTransferObjects.orders;

import com.example.myBarSystemAPI.models.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderSaveRequest {

    private String time;
    private int tableNumber;
    private List<Product> products;
    private int discountPercent;
}
