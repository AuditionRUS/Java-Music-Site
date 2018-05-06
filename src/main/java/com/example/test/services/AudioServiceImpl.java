package com.example.test.services;

import com.example.test.entities.Audio;
import com.example.test.repositories.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public class AudioServiceImpl implements AudioService {

    int PAGE_SIZE = 5;

    @Autowired
    public AudioRepository audioRepository;

    @Override
    public Audio save(Audio audio) {
        return audioRepository.save(audio);
    }

    @Override
    public void deleteById(int id) {
        audioRepository.deleteById(id);
    }

    @Override
    public Optional<Audio> findById(int id) {
        return audioRepository.findById(id);
    }

    @Override
    public Page<Audio> findAll(int pageAudio) {
        return audioRepository.findAll(new PageRequest(pageAudio,PAGE_SIZE));
    }
}
