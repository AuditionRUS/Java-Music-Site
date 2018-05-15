package com.example.test.services.authentification;

import com.example.test.entities.Audio;
import com.example.test.entities.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {

    User save(User user);

    User findByUsername(String username);
}
