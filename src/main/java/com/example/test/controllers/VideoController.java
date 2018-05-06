package com.example.test.controllers;

import com.example.test.entities.Audio;
import com.example.test.entities.Video;
import com.example.test.services.AudioService;
import com.example.test.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/saveVideo")
    public String saveVideo(Video video){
        videoService.save(video);
        return "redirect:/";
    }

    @GetMapping("/deleteVideo")
    public String deleteVideo(Integer id){
        videoService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/findOneVideo")
    @ResponseBody
    public Optional<Video> findOneVideo(Integer id){
        return videoService.findById(id);
    }

}
