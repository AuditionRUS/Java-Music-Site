package com.example.test.repositories;

import com.example.test.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer>{
}
