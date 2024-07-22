package com.meli.futebol.service;

import com.meli.futebol.dto.EstadioRequestDTO;
import com.meli.futebol.dto.EstadioResponseDTO;
import com.meli.futebol.model.Estadio;
import com.meli.futebol.repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository estadioRepository;

    public EstadioResponseDTO cadastrar(EstadioRequestDTO dto) {
        Estadio novoEstadio = converterEstadioRequestDTO(dto);
        estadioRepository.save(novoEstadio);
        return null;
    }

    private Estadio converterEstadioRequestDTO(EstadioRequestDTO dto) {
        Estadio estadio = new Estadio();
        estadio.setNome(dto.getNome());
        estadio.setEstado(dto.getEstado());
        estadio.setQuantidadeMaxima(dto.getQuantidadeMaxima());
        return estadio;
    }
    private EstadioResponseDTO converterEstadio(Estadio estadio) {
        EstadioResponseDTO dto = new EstadioResponseDTO();
        dto.setId(estadio.getId());
        dto.setNome(estadio.getNome());
        dto.setEstado(estadio.getEstado());
        dto.setQuantidadeMaxima(estadio.getQuantidadeMaxima());
        return dto;
    }
}
