package com.example.myBarSystemAPI.dataTransferObjects.orders;

import com.example.myBarSystemAPI.models.Product;

import java.util.List;

public class OrderResponse {

    private String time;
    private int tableNumber;
    private List<Product> products;
    private int discountPercent;
}
