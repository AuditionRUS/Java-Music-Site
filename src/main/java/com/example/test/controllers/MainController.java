package com.example.test.controllers;

import com.example.test.entities.AudioType;
import com.example.test.entities.Video;
import com.example.test.services.ServiceAudio;
import com.example.test.services.ServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ServiceAudio audioService;

    @Autowired
    private ServiceMain<Video> videoService;

    @Autowired
    private ServiceMain<AudioType> audioTypeService;


    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue = "0") int pageAudio,
                           @RequestParam(defaultValue = "0")int pageVideo,
                            @RequestParam(defaultValue = "0")int pageAudioType,
                           @RequestParam(defaultValue = "0")int pageUser, String musicName){
        model.addAttribute("dataAudio", audioService.findAll(pageAudio, musicName));
        model.addAttribute("currentPageAudio", pageAudio);
        model.addAttribute("dataAudioType", audioTypeService.findAll(pageAudioType));
        model.addAttribute("currentPageAudioType", pageAudioType);
        return "audio";
    }

}
