package com.example.test;

import com.example.test.entities.Good;
import com.example.test.repositories.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TestApplication{

	@Autowired
	private GoodRepository goodRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
