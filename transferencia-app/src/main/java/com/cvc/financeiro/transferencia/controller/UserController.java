package com.cvc.financeiro.transferencia.controller;

import com.cvc.financeiro.transferencia.exception.TaxaException;
import com.cvc.financeiro.transferencia.exception.TransferenciaException;
import com.cvc.financeiro.transferencia.request.LoginRequestDTO;
import com.cvc.financeiro.transferencia.request.UserRequestDTO;
import com.cvc.financeiro.transferencia.response.TransferenciaResponse;
import com.cvc.financeiro.transferencia.response.UserResponseDTO;
import com.cvc.financeiro.transferencia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<UserResponseDTO> post(RequestEntity<UserRequestDTO> request) {
        this.userService.createUser(request.getBody().toData());
        

        return null;
    }

}