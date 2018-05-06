package com.example.test.controllers;

import com.example.test.repositories.GoodRepository;
import com.example.test.repositories.OrderRepository;
import com.example.test.services.AudioService;
import com.example.test.services.GoodService;
import com.example.test.services.OrderLineService;
import com.example.test.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private AudioService audioService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderLineService orderLineService;


    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue = "0") int pageAudio,
                           @RequestParam(defaultValue = "0")int pageOrder,
                           @RequestParam(defaultValue = "0")int pageOrderLine){
        model.addAttribute("dataAudio", audioService.findAll(pageAudio));
        model.addAttribute("currentPageAudio", pageAudio);
        
        model.addAttribute("dataOrder", orderService.findAll(pageOrder));
        model.addAttribute("currentPageOrder", pageOrder);

        model.addAttribute("dataOrderLine", orderLineService.findAll(pageOrderLine));
        model.addAttribute("currentPageOrderLine", pageOrderLine);
        return "index";
    }

}
