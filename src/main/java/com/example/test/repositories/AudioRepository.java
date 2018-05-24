package com.example.test.repositories;

import com.example.test.entities.Audio;
import com.example.test.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AudioRepository extends JpaRepository<Audio,Integer> {
    Page<Audio> findAllByName(String musicName, Pageable pageable);
}
