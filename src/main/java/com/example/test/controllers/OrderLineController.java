package com.example.test.controllers;

import com.example.test.entities.OrderLine;
import com.example.test.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    @PostMapping("/saveOrderLine")
    public String saveOrderLine(OrderLine orderLine){
        System.out.println(orderLine.getIdB());
        orderLineService.save(orderLine);
        return "redirect:/";
    }

    @GetMapping("/deleteOrderLine")
    public String deleteOrderLine(Integer id){
        orderLineService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/findOneOrderLine")
    @ResponseBody
    public Optional<OrderLine> findOneOrderLine(Integer id){
        return orderLineService.findById(id);
    }
}
