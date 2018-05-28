package com.example.test.services;

import com.example.test.entities.Audio;
import com.example.test.entities.PlayList;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ServicePlayList {
    PlayList save(PlayList playList);

    void deleteById(int id);

    Optional<PlayList> findById(int id);

    Page<PlayList> findAll(int playlistShow,int pagePlayList, String playlistName);

}
