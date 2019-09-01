package com.cvc.financeiro.transferencia.request;


import com.cvc.financeiro.transferencia.service.dto.UserDataDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NewUserResquestDTO {

    private String email;
    private String password;


    public UserDataDTO toData(NewUserResquestDTO newUser){
        UserDataDTO userData = new UserDataDTO();
        userData.setEmail(newUser.email);
        userData.setPassword(newUser.password);

        return userData;
    }

}
