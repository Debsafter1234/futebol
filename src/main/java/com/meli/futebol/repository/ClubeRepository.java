package com.meli.futebol.repository;

import com.meli.futebol.enuns.Estado;
import com.meli.futebol.enuns.Status;
import com.meli.futebol.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClubeRepository extends JpaRepository<Clube, Long> {
    boolean existsByNomeAndSede(String nome, Estado sede);

    @Query(value = "SELECT c.status FROM Clube c WHERE c.id = :idClube", nativeQuery = true)
    Status buscarStatusClube(Long idClube);
}

