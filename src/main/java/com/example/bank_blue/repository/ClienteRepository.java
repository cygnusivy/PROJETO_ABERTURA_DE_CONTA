package com.example.bank_blue.repository;

import com.example.bank_blue.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findClienteById(Integer id);
    boolean existsByCpfCnpj(String cpfCnpj);
}