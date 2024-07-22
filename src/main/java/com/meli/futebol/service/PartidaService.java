package com.meli.futebol.service;

import com.meli.futebol.model.Clube;
import com.meli.futebol.model.Estadio;
import com.meli.futebol.repository.ClubeRepository;
import com.meli.futebol.repository.EstadioRepository;
import lombok.Data;

import com.meli.futebol.dto.PartidaRequestDTO;
import com.meli.futebol.dto.PartidaResponseDTO;
import com.meli.futebol.model.Partida;
import com.meli.futebol.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@Service
public class PartidaService {

    @Autowired
    private ClubeRepository clubeRepository;

    @Autowired
    private EstadioRepository estadioRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    public Partida converterESalvarPartidaRequestDTO(PartidaRequestDTO dto) {
        Clube clubeCasa = clubeRepository.findById(dto.getClubeCasaId()).orElseThrow();
        Clube clubeVisitante = clubeRepository.findById(dto.getClubeVisitanteId()).orElseThrow();
        Estadio estadio = estadioRepository.findByNome(dto.getNomeEstadio());
        Partida partida = new Partida(clubeCasa, clubeVisitante, dto.getResultado(), estadio, dto.getDataHoraPartida());
        partidaRepository.save(partida);
        return partida;

    }

    public PartidaResponseDTO converterPartidaResponseDTO(Partida partida) {
        PartidaResponseDTO responseDTO = new PartidaResponseDTO();
        responseDTO.setId(partida.getId());
        responseDTO.setClubeCasaNome(partida.getClubeCasa().getNome());
        responseDTO.setClubeVisitanteNome(partida.getClubeVisitante().getNome());
        responseDTO.setDataHora(partida.getDataPartida());
        return responseDTO;
    }


//    public PartidaResponseDTO cadastrar(PartidaRequestDTO dto) {
//      var  partidaSalva = converterESalvarPartidaRequestDTO(dto);
//        return converterPartidaResponseDTO(partidaSalva);
//    }

    //    public PartidaResponseDTO cadastrar(PartidaRequestDTO dto) {
//        Partida novaPartida = converterPartidaRequestDTO(dto);
//        Partida partidaSalva = partidaRepository.save(novaPartida);
//        return converterPartidaResponseDTO(partidaSalva);
//    }

    //    private Partida converterPartidaRequestDTO(PartidaRequestDTO dto) {
//        Partida partida = new Partida();
//        partida.setClubeCasa(dto.getClubeCasaId());
//        partida.setClubeVisitante(dto.getClubeVisitanteId());
//        partida.setDataPartida(dto.getDataPartida());
//        return partida;
//    }
//


//
//    public PartidaResponseDTO cadastrarPartida(PartidaRequestDTO requestDTO) {
//        return cadastrar(requestDTO);
//    }
}
