package com.cvc.financeiro.transferencia.response;

import com.cvc.financeiro.transferencia.entities.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NewUserResponseDTO {

    private String username;
    private User.UserStatus userStatus;

    public NewUserResponseDTO(User user){
        this.username = user.getEmail();
        this.userStatus = user.getStatus();
    }
}
