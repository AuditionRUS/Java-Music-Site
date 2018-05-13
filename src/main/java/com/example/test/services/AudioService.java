package com.example.test.services;

import com.example.test.entities.Audio;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface AudioService{

        Audio save(Audio audio);

        void deleteById(int id);

        Optional<Audio> findById(int id);

        Page<Audio> findAll(int pageAudio);

}
