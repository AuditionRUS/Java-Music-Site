package com.example.test.services;

import com.example.test.entities.Audio;
import com.example.test.entities.Rock;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface RockService {
    Rock save(Rock audio);

    void deleteById(int id);

    Optional<Rock> findById(int id);

    Page<Rock> findAll(int pageRock);
}
