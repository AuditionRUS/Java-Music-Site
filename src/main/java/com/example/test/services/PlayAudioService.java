package com.example.test.services;

import com.example.test.entities.Audio;
import com.example.test.entities.PlayAudio;
import com.example.test.entities.PlayList;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PlayAudioService {

    PlayAudio save(PlayAudio playAudio);

    void deleteById(int id);

    Optional<PlayAudio> findById(int id);

    Page<PlayAudio> findAll(int pagePlayAudio);
}
