package com.example.test.services;

import com.example.test.entities.Good;
import com.example.test.repositories.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class GoodServiceImpl implements GoodService{

    int PAGE_SIZE = 5;

    @Autowired
    public GoodRepository goodRepository;

    @Override
    public Good save(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public void deleteById(int id) {
        goodRepository.deleteById(id);
    }

    @Override
    public Optional<Good> findById(int id) {
        return goodRepository.findById(id);
    }

    @Override
    public Page<Good> findAll(int pageGood) {
        return goodRepository.findAll(new PageRequest(pageGood,PAGE_SIZE));
    }
}
