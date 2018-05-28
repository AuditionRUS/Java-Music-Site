package com.example.test.services;

import com.example.test.entities.AudioType;
import com.example.test.entities.PlayList;
import com.example.test.repositories.AudioTypeRepository;
import com.example.test.repositories.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayListServiceImpl implements ServicePlayList {

    int PAGE_SIZE = 5;

    @Autowired
    public PlayListRepository playListRepository;

    @Override
    public PlayList save(PlayList playList) {
        return playListRepository.save(playList);
    }

    @Override
    public void deleteById(int id) {
        playListRepository.deleteById(id);
    }

    @Override
    public Optional<PlayList> findById(int id) {
        return playListRepository.findById(id);
    }

    @Override
    public Page<PlayList> findAll(int playlistShow, int pagePlayList, String playlistName) {
        if (playlistName != "" && playlistName != null ){
            System.out.println("hello");
            System.out.println(playlistShow);
            System.out.println(playlistName);
            return  playListRepository.findAllByName(playlistShow, playlistName,new PageRequest(pagePlayList, PAGE_SIZE));
        } else {
            System.out.println(playlistShow);
            System.out.println(playlistName);
            return playListRepository.findAllByName(playlistShow, new PageRequest(pagePlayList, PAGE_SIZE));
        }
    }
}
