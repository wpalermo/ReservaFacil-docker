package com.cvc.financeiro.transferencia.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue
    private String id;

    @Column
    private String uuid;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column
    private String cpf;

    @Column
    private String email;

    @Column
    private String senha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Transient
    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder{

        private User user;

        public UserBuilder(){
            user = new User();
            user.setUuid(UUID.randomUUID().toString());
        }

        public UserBuilder setNome(String nome){
            this.user.setNome(nome);
            return this;
        }

        public UserBuilder setSobrenome(String sobrenome){
            this.user.setSobrenome(sobrenome);
            return this;
        }

        public UserBuilder setEmail(String email){
            this.user.setEmail(email);
            return this;
        }

        public UserBuilder setCpf(String cpf){
            this.user.setCpf(cpf);
            return this;
        }

        public UserBuilder setSenha(String senha){
            this.user.setSenha(senha);
            return this;
        }

        public User build(){
            return this.user;
        }

    }
}
