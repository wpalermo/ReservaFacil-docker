package com.cvc.financeiro.transferencia.repository;

import com.cvc.financeiro.transferencia.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
