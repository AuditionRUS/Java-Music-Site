package com.example.test.services.authentification;

import com.example.test.entities.Role;
import com.example.test.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    int PAGE_SIZE = 5;

    @Autowired
    public RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public Page<Role> findAll(int pageUser) {
        return roleRepository.findAll(new PageRequest(pageUser,PAGE_SIZE));
    }

}
