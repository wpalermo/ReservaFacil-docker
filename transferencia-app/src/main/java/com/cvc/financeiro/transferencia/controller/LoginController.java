package com.cvc.financeiro.transferencia.controller;

import com.cvc.financeiro.transferencia.entities.Conta;
import com.cvc.financeiro.transferencia.exception.TaxaException;
import com.cvc.financeiro.transferencia.exception.TransferenciaException;
import com.cvc.financeiro.transferencia.request.LoginRequestDTO;
import com.cvc.financeiro.transferencia.response.TransferenciaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class LoginController {




    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<TransferenciaResponse> post(RequestEntity<LoginRequestDTO> request) {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (TaxaException | TransferenciaException te) {
            return new ResponseEntity<>(new TransferenciaResponse(te.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
    }

}
