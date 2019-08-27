package com.cvc.financeiro.transferencia.service.impl;

import com.cvc.financeiro.transferencia.entities.User;
import com.cvc.financeiro.transferencia.repository.UserRepository;
import com.cvc.financeiro.transferencia.service.UserService;
import com.cvc.financeiro.transferencia.service.dto.UserDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserDataDTO userData) {

        User user = User.builder()
                .setCpf(userData.getCpf())
                .setEmail(userData.getEmail())
                .setNome(userData.getNome())
                .setSobrenome(userData.getSobrenome())
                .setSenha(passwordEncoder.encode(userData.getSenha()))
                .build();

        user = userRepository.save(user);

        return user;
    }



}
