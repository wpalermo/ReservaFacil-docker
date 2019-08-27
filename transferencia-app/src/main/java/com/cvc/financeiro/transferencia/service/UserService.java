package com.cvc.financeiro.transferencia.service;

import com.cvc.financeiro.transferencia.entities.User;
import com.cvc.financeiro.transferencia.service.dto.UserDataDTO;

public interface UserService {

    User createUser(UserDataDTO userData);


}
