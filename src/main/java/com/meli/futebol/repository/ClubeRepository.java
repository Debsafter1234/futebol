package com.meli.futebol.repository;

import com.meli.futebol.enuns.Estado;
import com.meli.futebol.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubeRepository extends JpaRepository<Clube, Long> {
    boolean existsByNomeAndSede(String nome, Estado sede);
}

