package com.example.test.controllers;

import com.example.test.entities.AudioType;
import com.example.test.entities.Role;
import com.example.test.entities.User;
import com.example.test.repositories.UserRepository;
import com.example.test.services.ServiceMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceMain<Role> roleService;

    @Autowired
    private ServiceMain<AudioType> audioTypeService;

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

        userRepository.save(user);
        return "redirect:/";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/saveUser")
    public String saveUser(@Valid Role role,@Valid User user, BindingResult bindingResult,
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

        userRepository.save(user);
        return "redirect:/admin";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String showAdmin(Model model, @RequestParam(defaultValue = "0") int pageAudio,
                           @RequestParam(defaultValue = "0")int pageAudioType,
                           @RequestParam(defaultValue = "0")int pageUser,
                           HttpServletRequest req){
        model.addAttribute("dataUser", userRepository.findAll(new PageRequest(pageUser, 10)));
        model.addAttribute("currentPageUser", pageUser);
        model.addAttribute("dataAudioType", audioTypeService.findAll(pageAudioType));
        model.addAttribute("currentPageAudioType", pageAudioType);
        return "admin";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin/deleteUser")
    public String deleteUser(int id){
        Optional<User> user = userRepository.findById(id);
        System.out.println("Привет user");
        System.out.println(user.get());
        user.get().setRoles(null);
        userRepository.deleteById(id);
        return "redirect:/admin";
    }
}
