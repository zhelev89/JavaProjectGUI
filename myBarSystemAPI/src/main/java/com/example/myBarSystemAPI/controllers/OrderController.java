package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.dataTransferObjects.orders.OrderResponse;
import com.example.myBarSystemAPI.dataTransferObjects.orders.OrderSaveRequest;
import com.example.myBarSystemAPI.services.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderController {

    private OrderService orderService;

    public ResponseEntity<OrderResponse> save(OrderSaveRequest orderSaveRequest) {
        return null;
    }
}
