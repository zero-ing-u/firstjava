package com.multicampus.b01.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Log4j2
@Service
@RequiredArgsConstructor

public class CustomUserDetailsService implements UserDetailsService {

    PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUserName" + username);
        UserDetails userDetails = User.builder().username("user1")
                .password(passwordEncoder.encode("1111"))
                .authorities("Role_User")
                .build();
        return userDetails;
    }
}
