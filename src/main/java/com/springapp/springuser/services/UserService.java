package com.springapp.springuser.services;

import com.springapp.springuser.models.ApplicationUser;

public interface UserService {
    void save(ApplicationUser applicationUser);

    ApplicationUser findByUsername(String username);
    ApplicationUser findByEmail(String email);
}