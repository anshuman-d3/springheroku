package com.springapp.springuser.controllers;

import com.springapp.springuser.models.ApplicationUser;
import com.springapp.springuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    private ApplicationUser applicationUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username);
    }
}
