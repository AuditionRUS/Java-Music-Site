package com.example.test.repositories;

import com.example.test.entities.User;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    User findAllByUsername(String username);
}
