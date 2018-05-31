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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Iterator;
import java.util.Set;

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

    @Autowired
    private UserRepository userRep;


    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue = "0") int pageAudio,
                           @RequestParam(defaultValue = "0")int pageVideo,
                            @RequestParam(defaultValue = "0")int pageAudioType,
                           @RequestParam(defaultValue = "0")int pageUser,
                           @RequestParam(defaultValue = "0")int pagePlayList,
                           String musicName, String playlistName,
                           HttpServletRequest req){
        model.addAttribute("dataAudio", audioService.findAll(pageAudio, musicName));
        model.addAttribute("currentPageAudio", pageAudio);
        model.addAttribute("dataAudioType", audioTypeService.findAll(pageAudioType));
        model.addAttribute("currentPageAudioType", pageAudioType);
        int plList;Set<Role> roles=null;
        if (req.getUserPrincipal()==null){
             plList = -1;
        }else{
            plList = userRep.findAllByUsername(req.getUserPrincipal().getName()).getId();
            //model.addAttribute("AllRoles", userRepository.findById(plList));
        }
        model.addAttribute("playList", playListServiceMain.findAll(plList, pagePlayList, playlistName));
        model.addAttribute("currentPagePlayList", pagePlayList);
        return "audio";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/playlist")
    public String showplaylist(Model model, @RequestParam(defaultValue = "0")int pagePlayList,
                               @RequestParam(defaultValue = "0")int pageAudioType,
                               @RequestParam(defaultValue = "0")int pageUser, String playlistName,
                               HttpServletRequest req){
        model.addAttribute("playList", playListServiceMain.findAll(userRep.findAllByUsername(req.getUserPrincipal().getName()).getId(), pagePlayList, playlistName));
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
    public String saveAudioToPlaylist(@Valid PlayAudio playAudio, BindingResult bindingResult,
                                      Model model){
        System.out.println(playAudio.getAudioId());
        System.out.println(playAudio.getPlayListId());
        playAudioServiceMain.save(playAudio);
        return "redirect:/";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/playlistAudio")
    public String playlistAudio(Model model, @RequestParam(defaultValue = "0")int pagePlayListAudio,
                                @RequestParam(defaultValue = "0")int pageAudioType,
                                @RequestParam(defaultValue = "0")int pageUser,
                                String playListName, int playListGoal){
        model.addAttribute("dataAudioPlayList", audioService.findAllByPlayAudio(playListGoal, pagePlayListAudio, playListName));
        model.addAttribute("currentPagePlayList", pagePlayListAudio);
        model.addAttribute("dataUser", userRepository.findAll(new PageRequest(pageUser,10)));
        model.addAttribute("currentPageUser", pageUser);
        model.addAttribute("dataAudioType", audioTypeService.findAll(pageAudioType));
        model.addAttribute("currentPageAudioType", pageAudioType);
        model.addAttribute("playListGoal",playListGoal);
        return "playlistAudio";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/deletePlaylist")
    public String deletePlaylist(int id){
        playListServiceMain.deleteById(id);
        return "redirect:/";
    }

}
