package com.cvc.financeiro.transferencia.request;

import com.cvc.financeiro.transferencia.service.dto.UserDataDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserRequestDTO {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String senha;


    public UserDataDTO toData(){
        UserDataDTO data = new UserDataDTO();

        data.setName(this.nome);
        data.setSecondName(this.sobrenome);
        data.setDocumentNumber(this.cpf);
        data.setEmail(this.email);
        data.setPassword(this.senha);

        return data;
    }
}
