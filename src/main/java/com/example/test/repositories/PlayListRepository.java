package com.example.test.repositories;

import com.example.test.entities.Audio;
import com.example.test.entities.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListRepository extends JpaRepository<PlayList,Integer> {
}
