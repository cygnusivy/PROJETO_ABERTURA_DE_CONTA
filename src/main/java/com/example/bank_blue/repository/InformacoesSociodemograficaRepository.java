package com.example.bank_blue.repository;

import com.example.bank_blue.model.InformacoesSociodemograficas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InformacoesSociodemograficaRepository extends JpaRepository<InformacoesSociodemograficas, Integer> {

    Optional<InformacoesSociodemograficas> findById(Integer id);
    List<InformacoesSociodemograficas> findAll();

}
