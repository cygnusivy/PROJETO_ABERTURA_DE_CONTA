package com.example.bank_blue.repository;

import com.example.bank_blue.model.clienteModel.Cliente;
import com.example.bank_blue.model.contaModel.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    Optional<Conta> findContaById(long id);
    Optional<Conta> findContaByNumeroConta(String numeroConta);

    boolean existsById(long id);
}