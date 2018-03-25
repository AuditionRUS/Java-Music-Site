package com.example.test.controllers;

import com.example.test.entities.Good;
import com.example.test.entities.Order;
import com.example.test.repositories.OrderRepository;
import com.example.test.services.GoodService;
import com.example.test.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public String saveOrder(Order order){
        System.out.println(order.getId());
        orderService.save(order);
        return "redirect:/";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(Integer id){
        orderService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/findOneOrder")
    @ResponseBody
    public Optional<Order> findOneOrder(Integer id){
        return orderService.findById(id);
    }
}
