package com.example.test.controllers;

import com.example.test.entities.AudioType;
import com.example.test.services.ServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class AudioTypeController {

    @Autowired
    private ServiceMain<AudioType> audioTypeService;

    @PostMapping("/saveAudioType")
    public String saveAudioType(AudioType audioType){
        audioTypeService.save(audioType);
        return "redirect:/";
    }

    @GetMapping("/deleteAudioType")
    public String deleteAudioType(Integer id){
        audioTypeService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/findOneAudioType")
    @ResponseBody
    public Optional<AudioType> findOneAudioType(Integer id){
        return audioTypeService.findById(id);
    }
}
