package com.example.test.services;

import com.example.test.entities.Order;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface OrderService {

    Order save(Order order);

    void deleteById(int id);

    Optional<Order> findById(int id);

    Page<Order> findAll(int pageOrder);

}