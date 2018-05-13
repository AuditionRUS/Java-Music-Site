package com.example.test.repositories;

import com.example.test.entities.AudioType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioTypeRepository extends JpaRepository<AudioType, Integer> {
}
