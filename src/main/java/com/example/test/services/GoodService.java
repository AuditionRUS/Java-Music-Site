package com.example.test.services;

import com.example.test.entities.Good;
import com.example.test.repositories.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

public interface GoodService {

    Good save(Good good);

    void deleteById(int id);

    Optional<Good> findById(int id);

    Page<Good> findAll(int pageGood);

}
