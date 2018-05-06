package com.example.test.services;

import com.example.test.entities.Video;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface VideoService {

    Video save(Video video);

    void deleteById(int id);

    Optional<Video> findById(int id);

    Page<Video> findAll(int pageVideo);

}
