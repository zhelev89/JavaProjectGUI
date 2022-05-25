package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.models.Order;
import com.example.myBarSystemAPI.repositories.OrderRepository;
import com.example.myBarSystemAPI.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public Order save(Order order) {
        Objects.requireNonNull(order);
        return orderRepository.save(order);
    }
}
