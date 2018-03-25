package com.example.test.services;

import com.example.test.entities.Good;
import com.example.test.entities.Order;
import com.example.test.repositories.GoodRepository;
import com.example.test.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    int PAGE_SIZE = 5;

    @Autowired
    public OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public Page<Order> findAll(int pageOrder) {
        return orderRepository.findAll(new PageRequest(pageOrder,PAGE_SIZE));
    }
}
