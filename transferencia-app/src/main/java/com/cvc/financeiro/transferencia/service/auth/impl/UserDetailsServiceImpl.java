package com.cvc.financeiro.transferencia.service.auth.impl;

import com.cvc.financeiro.transferencia.entities.User;
import com.cvc.financeiro.transferencia.exception.SystemAuthException;
import com.cvc.financeiro.transferencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        //PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        if(user == null){
            throw new SystemAuthException("user not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("ADMIN")
                .build();
    }
}
