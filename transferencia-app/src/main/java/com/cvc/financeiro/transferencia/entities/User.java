package com.cvc.financeiro.transferencia.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String uuid;

    @Column
    private String name;

    @Column
    private String secondName;

    @Column
    private String documentNumber;

    @Column
    private String email;

    @Column
    private String password;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

        public UserBuilder setName(String nome){
            this.user.setName(nome);
            return this;
        }

        public UserBuilder setSecondName(String sobrenome){
            this.user.setSecondName(sobrenome);
            return this;
        }

        public UserBuilder setEmail(String email){
            this.user.setEmail(email);
            return this;
        }

        public UserBuilder setDocumentNumber(String cpf){
            this.user.setDocumentNumber(cpf);
            return this;
        }

        public UserBuilder setPassword(String senha){
            this.user.setPassword(senha);
            return this;
        }

        public User build(){
            return this.user;
        }

    }
}
