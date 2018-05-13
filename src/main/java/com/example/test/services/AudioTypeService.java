package com.example.test.services;

import com.example.test.entities.Audio;
import com.example.test.entities.AudioType;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface AudioTypeService {

    AudioType save(AudioType audioType);

    void deleteById(int id);

    Optional<AudioType> findById(int id);

    Page<AudioType> findAll(int pageAudioType);

}
