package com.example.test.repositories;

import com.example.test.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Integer> {
}
