package com.springapp.springuser.services;

import com.springapp.springuser.models.ApplicationUser;
import com.springapp.springuser.repositories.UserRepository;
import com.springapp.springuser.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(s);

        ApplicationUser applicationUser = null;

        if (matcher.find()) {
            applicationUser = userRepository.findByEmail(s);
        }
        else applicationUser = userRepository.findByUsername(s);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

//        for (UserRole userRole : applicationUser.getUserRoles()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getName()));
//        }

        return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(), applicationUser.getPassword(), grantedAuthorities);
    }
}
