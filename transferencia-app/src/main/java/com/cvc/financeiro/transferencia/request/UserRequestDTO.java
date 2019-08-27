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

        data.setNome(this.nome);
        data.setSobrenome(this.sobrenome);
        data.setCpf(this.cpf);
        data.setEmail(this.email);
        data.setSenha(this.senha);

        return data;
    }
}
