package com.example.test.controllers;

import com.example.test.entities.Audio;
import com.example.test.entities.AudioType;
import com.example.test.entities.Role;
import com.example.test.entities.User;
import com.example.test.repositories.UserRepository;
import com.example.test.services.ServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceMain<Role> roleService;

    @GetMapping("/all")
    public String hello(){
        return "Hello";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello(Model model) {
        return "welcome";
    }


    @PostMapping("/reg")
    public String reg(@Valid Role role,@Valid User user, BindingResult bindingResult,
                      Model model){
        if( bindingResult.hasErrors())
        {
            System.out.println( "There are errors! {}"+bindingResult );
        }
        System.out.println("Привет");

        if (role.getRole().length() >= 5){
            role.setRole(role.getRole().substring(1));
        }

        roleService.save(role);
        Set<Role> hset = new HashSet<Role>();
        hset.add(role);
        user.setRoles(hset);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println(encodedPassword);
        user.setPassword(encodedPassword);
        System.out.println(role.getRole());
        System.out.println(role.getRoleId());


        //System.out.println(hset);

       // Нужно создать бин для user role и использовать репозиторий

        userRepository.save(user);

        // Сделать добавление поля в таблицу USER_ROLE

        return "redirect:/";
    }
}
