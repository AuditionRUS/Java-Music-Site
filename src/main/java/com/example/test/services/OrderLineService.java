package com.example.test.services;

import com.example.test.entities.OrderLine;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface OrderLineService {

    OrderLine save(OrderLine order);

    void deleteById(int id);

    Optional<OrderLine> findById(int id);

    Page<OrderLine> findAll(int pageOrderLine);

}
