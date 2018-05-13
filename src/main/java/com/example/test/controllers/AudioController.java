package com.example.test.controllers;

import com.example.test.entities.Audio;
import com.example.test.services.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class AudioController {

    @Autowired
    private AudioService audioService;

    @PostMapping("/saveAudio")
    public String saveAudio(Audio audio){
        audioService.save(audio);
        return "redirect:/";
    }

    @GetMapping("/deleteAudio")
    public String deleteAudio(Integer id){
        audioService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/findOneAudio")
    @ResponseBody
    public Optional<Audio> findOneAudio(Integer id){
        return audioService.findById(id);
    }

}
