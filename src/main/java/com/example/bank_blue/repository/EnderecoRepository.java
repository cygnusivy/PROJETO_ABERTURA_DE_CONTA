package com.example.bank_blue.repository;

import com.example.bank_blue.model.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    Optional<Endereco> findEnderecoById(long id);
    boolean existsById(long id);
}