package com.example.test.services;

import com.example.test.entities.Audio;
import com.example.test.entities.Rock;
import com.example.test.repositories.AudioRepository;
import com.example.test.repositories.RockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RockServiceImpl implements RockService {

    int PAGE_SIZE = 5;

    @Autowired
    public RockRepository rockRepository;

    @Override
    public Rock save(Rock rock) {
        return rockRepository.save(rock);
    }

    @Override
    public void deleteById(int id) {
        rockRepository.deleteById(id);
    }

    @Override
    public Optional<Rock> findById(int id) {
        return rockRepository.findById(id);
    }

    @Override
    public Page<Rock> findAll(int pageRock) {
        return rockRepository.findAll(new PageRequest(pageRock,PAGE_SIZE));
    }
}
