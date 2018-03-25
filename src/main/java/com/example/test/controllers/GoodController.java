package com.example.test.controllers;

import com.example.test.entities.Good;
import com.example.test.repositories.GoodRepository;
import com.example.test.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class GoodController {

    @Autowired
    private GoodService goodService;

    @PostMapping("/saveGood")
    public String saveGood(Good good){
        goodService.save(good);
        return "redirect:/";
    }

    @GetMapping("/deleteGood")
    public String deleteGood(Integer id){
        goodService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/findOneGood")
    @ResponseBody
    public Optional<Good> findOneGood(Integer id){
        return goodService.findById(id);
    }
}
