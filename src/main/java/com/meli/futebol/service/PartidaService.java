package com.meli.futebol.service;

import com.meli.futebol.exeption.ExeptionPersonalizada;
import com.meli.futebol.model.Clube;
import com.meli.futebol.model.Estadio;

import com.meli.futebol.dto.PartidaRequestDTO;
import com.meli.futebol.dto.PartidaResponseDTO;
import com.meli.futebol.model.Partida;
import com.meli.futebol.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PartidaService {

    @Autowired
    private ClubeService clubeService;

    @Autowired
    private EstadioService estadioService;

    @Autowired
    private PartidaRepository partidaRepository;



    public PartidaResponseDTO salvarPartida(PartidaRequestDTO dto) {
        validarPartida(dto);
        Clube clubeCasa = clubeService.getClube(dto.getClubeCasaId());
        Clube clubeVisitante = clubeService.getClube(dto.getClubeVisitanteId());
        Estadio estadio = estadioService.getEstadioBynome(dto.getNomeEstadio());
        Partida partida = new Partida(clubeCasa,
                clubeVisitante,
                dto.getResultadoVisitante(),
                dto.getResultadoCasa(),
                estadio,
                dto.getDataHoraPartida());
        partidaRepository.save(partida);
        return converterPartidaResponseDTO(partida);
    }

    private void validarPartida(PartidaRequestDTO dto) {
        if (dto.getClubeCasaId() == dto.getClubeVisitanteId()) {
            throw new ExeptionPersonalizada("O clube visitante não pode ser o mesmo que o clube da casa", 400);
        }

        if (dto.getResultadoCasa() < 0 || dto.getResultadoVisitante() < 0) {
            throw new ExeptionPersonalizada("O resultado da partida não pode ser menor que 0", 400);
        }
        if (dto.getDataHoraPartida().isAfter(LocalDateTime.now())) {
            throw new ExeptionPersonalizada("A data da partida não pode ser no futuro", 400);
        }

        if (!clubeService.clubeAtivo(dto.getClubeCasaId()) || !clubeService.clubeAtivo(dto.getClubeVisitanteId())) {
            throw new ExeptionPersonalizada("Um ou mais clubes não estão ativos", 409);
        }

    }

    public PartidaResponseDTO converterPartidaResponseDTO(Partida partida) {
        PartidaResponseDTO responseDTO = new PartidaResponseDTO();
        responseDTO.setId(partida.getId());
        responseDTO.setClubeCasaNome(partida.getClubeCasa().getNome());
        responseDTO.setClubeVisitanteNome(partida.getClubeVisitante().getNome());
        responseDTO.setDataHora(partida.getDataPartida());
        responseDTO.setEstadio(partida.getEstadio().getNome());
        responseDTO.setResultadoCasa(partida.getResultadoCasa());
        responseDTO.setResultadoVisitante(partida.getResultadoVisitante());
        return responseDTO;
    }



}