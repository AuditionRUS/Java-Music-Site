package com.example.test.controllers;

import com.example.test.entities.*;
import com.example.test.repositories.UserRepository;
import com.example.test.services.ServiceAudio;
import com.example.test.services.ServiceMain;
import com.example.test.services.ServicePlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ServiceAudio audioService;

    @Autowired
    private ServiceMain<Video> videoService;

    @Autowired
    private ServiceMain<AudioType> audioTypeService;

    @Autowired
    private ServicePlayList playListServiceMain;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceMain<PlayAudio> playAudioServiceMain;


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

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/playlist")
    public String showplaylist(Model model, @RequestParam(defaultValue = "0")int pagePlayList,
                               @RequestParam(defaultValue = "0")int pageAudioType,
                               @RequestParam(defaultValue = "0")int pageUser, String playlistName ){
        model.addAttribute("playList", playListServiceMain.findAll(pagePlayList, playlistName));
        model.addAttribute("currentPagePlayList", pagePlayList);
        model.addAttribute("dataUser", userRepository.findAll(new PageRequest(pageUser,10)));
        model.addAttribute("currentPageUser", pageUser);
        model.addAttribute("dataAudioType", audioTypeService.findAll(pageAudioType));
        model.addAttribute("currentPageAudioType", pageAudioType);
        return "playlist";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("/playlistSave")
    public String savePlayList(PlayList playList){
        System.out.println(playList.getUser_id());
        System.out.println(playList.getDateAdd());
        playListServiceMain.save(playList);
        return "redirect:/";
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("/playListAudioSave")
    public String saveAudioToPlaylist(PlayAudio playAudio){
        System.out.println(playAudio);
        System.out.println(playAudio);
        playAudioServiceMain.save(playAudio);
        return "redirect:/";
    }

}
