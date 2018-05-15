package com.example.test.services.authentification;

import com.example.test.entities.Role;
import com.example.test.entities.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface RoleService {

    Role save(Role role);

    void deleteById(int id);

    Optional<Role> findById(int id);

    Page<Role> findAll(int pageRole);

}
