package com.example.test.repositories;

import com.example.test.entities.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface GoodRepository extends JpaRepository<Good,Integer>{

}
