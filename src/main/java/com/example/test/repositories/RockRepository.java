package com.example.test.repositories;

import com.example.test.entities.Rock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RockRepository extends JpaRepository<Rock, Integer> {
}
