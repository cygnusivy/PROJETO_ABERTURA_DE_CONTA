package com.example.bank_blue.repository;

import com.example.bank_blue.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

    Optional<Conta> findContaById(Integer id);
}