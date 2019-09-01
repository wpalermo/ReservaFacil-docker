package com.cvc.financeiro.transferencia.response;

import com.cvc.financeiro.transferencia.entities.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserResponseDTO {

    private String uuid;
    private String name;
    private String secondName;
    private String documentNumber;
    private String email;
    private User.UserStatus status;

    public UserResponseDTO(User user){
        this.uuid = user.getUuid();
        this.name = user.getName();
        this.secondName = user.getSecondName();
        this.documentNumber = user.getDocumentNumber();
        this.email = user.getEmail();
        this.status = user.getStatus();
    }

}
