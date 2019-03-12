package com.springapp.springuser.controllers;

import com.springapp.springuser.models.ApplicationUser;
import com.springapp.springuser.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<ApplicationUser> signUp(@RequestBody ApplicationUser applicationUser) {
        System.out.println("sign-up post method");
        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        try{
            userRepository.save(applicationUser);
            return new ResponseEntity<ApplicationUser>(applicationUser, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<ApplicationUser>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        System.out.println("saving applicationUser object successful");
    }
}