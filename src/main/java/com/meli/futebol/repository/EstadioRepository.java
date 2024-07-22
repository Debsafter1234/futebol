package com.meli.futebol.repository;

import com.meli.futebol.model.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadioRepository extends JpaRepository<Estadio, Long>{
boolean existsByNome(String nome);

    Estadio findByNome(String nomeEstadio);
}