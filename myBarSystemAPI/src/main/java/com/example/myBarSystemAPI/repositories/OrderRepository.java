package com.example.myBarSystemAPI.repositories;

import com.example.myBarSystemAPI.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
