package com.example.test.services;

import com.example.test.entities.Audio;
import com.example.test.entities.AudioType;
import com.example.test.repositories.AudioRepository;
import com.example.test.repositories.AudioTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AudioTypeServiceImpl implements ServiceMain<AudioType> {

    int PAGE_SIZE = 5;

    @Autowired
    public AudioTypeRepository audioTypeRepository;

    @Override
    public AudioType save(AudioType audioType) {
        return audioTypeRepository.save(audioType);
    }

    @Override
    public void deleteById(int id) {
        audioTypeRepository.deleteById(id);
    }

    @Override
    public Optional<AudioType> findById(int id) {
        return audioTypeRepository.findById(id);
    }

    @Override
    public Page<AudioType> findAll(int pageAudioType) {
        return audioTypeRepository.findAll(new PageRequest(pageAudioType,PAGE_SIZE));
    }
}
