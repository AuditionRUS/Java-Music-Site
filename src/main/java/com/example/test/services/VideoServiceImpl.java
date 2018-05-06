package com.example.test.services;

import com.example.test.entities.Audio;
import com.example.test.entities.Video;
import com.example.test.repositories.AudioRepository;
import com.example.test.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public class VideoServiceImpl implements VideoService {

    int PAGE_SIZE = 5;

    @Autowired
    public VideoRepository videoRepository;

    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public void deleteById(int id) {
        videoRepository.deleteById(id);
    }

    @Override
    public Optional<Video> findById(int id) {
        return videoRepository.findById(id);
    }

    @Override
    public Page<Video> findAll(int pageVideo) {
        return videoRepository.findAll(new PageRequest(pageVideo,PAGE_SIZE));
    }

}
