package com.springapp.springuser.services;

import com.springapp.springuser.models.ApplicationUser;
import com.springapp.springuser.repositories.UserRepository;
import com.springapp.springuser.repositories.UserRoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(ApplicationUser applicationUser) {
        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        applicationUser.setUserRoles(new HashSet<>(userRoleRepository.findAll()));
        userRepository.save(applicationUser);
    }

    @Override
    public ApplicationUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public ApplicationUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}