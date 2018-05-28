package com.example.test.services;

import com.example.test.entities.PlayAudio;
import com.example.test.entities.PlayList;
import com.example.test.repositories.PlayAudioRepository;
import com.example.test.repositories.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class PlayAudioServiceImpl implements ServiceMain<PlayAudio>{

    int PAGE_SIZE = 5;

    @Autowired
    public PlayAudioRepository playAudioRepository;

    @Override
    public PlayAudio save(PlayAudio playAudio) {
        try{
            return playAudioRepository.save(playAudio);
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public void deleteById(int id) {
        playAudioRepository.deleteById(id);
    }

    @Override
    public Optional<PlayAudio> findById(int id) {
        return playAudioRepository.findById(id);
    }

    @Override
    public Page<PlayAudio> findAll(int pagePlayAudio) {
        return playAudioRepository.findAll(new PageRequest(pagePlayAudio,PAGE_SIZE));
    }

}
