package com.cvc.financeiro.transferencia.service.impl;

import com.cvc.financeiro.transferencia.entities.User;
import com.cvc.financeiro.transferencia.repository.UserRepository;
import com.cvc.financeiro.transferencia.service.UserService;
import com.cvc.financeiro.transferencia.service.dto.UserDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserDataDTO userData) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        User user = User.builder()
                .setEmail(userData.getEmail())
                .setPassword(encoder.encode(userData.getPassword()))
                .build();

        return userRepository.save(user);
    }



}
