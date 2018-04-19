package com.example.test.services;

import com.example.test.entities.Order;
import com.example.test.entities.OrderLine;
import com.example.test.repositories.OrderLineRepository;
import com.example.test.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    int PAGE_SIZE = 5;

    @Autowired
    public OrderLineRepository orderLineRepository;

    @Override
    public OrderLine save(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public void deleteById(int id) {
        orderLineRepository.deleteById(id);
    }

    @Override
    public Optional<OrderLine> findById(int id) {
        return orderLineRepository.findById(id);
    }

    @Override
    public Page<OrderLine> findAll(int pageOrder) {
        return orderLineRepository.findAll(new PageRequest(pageOrder, PAGE_SIZE));
    }
}
