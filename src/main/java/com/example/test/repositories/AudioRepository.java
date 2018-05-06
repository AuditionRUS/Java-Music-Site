package com.example.test.repositories;

import com.example.test.entities.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio,Integer> {
}
