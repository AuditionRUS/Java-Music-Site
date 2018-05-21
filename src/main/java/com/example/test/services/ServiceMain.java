package com.example.test.services;

import com.example.test.entities.Audio;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ServiceMain<T> {

    T save(T audio);

    void deleteById(int id);

    Optional<T> findById(int id);

    Page<T> findAll(int pageAudio);
}
