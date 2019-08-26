package com.cvc.financeiro.transferencia.repository;

import org.springframework.data.repository.CrudRepository;

import com.cvc.financeiro.transferencia.entities.Conta;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository<Conta, String> {

}
