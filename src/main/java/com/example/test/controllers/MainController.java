package com.example.test.controllers;

import com.example.test.services.AudioService;
import com.example.test.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private AudioService audioService;

    @Autowired
    private VideoService videoService;


    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue = "0") int pageAudio,
                           @RequestParam(defaultValue = "0")int pageVideo,
                           @RequestParam(defaultValue = "0")int pageRock){
        model.addAttribute("dataAudio", audioService.findAll(pageAudio));
        model.addAttribute("currentPageAudio", pageAudio);

        return "index";
    }

}
