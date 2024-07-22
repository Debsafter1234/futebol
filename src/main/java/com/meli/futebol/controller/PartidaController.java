package com.meli.futebol.controller;

import com.meli.futebol.dto.PartidaRequestDTO;
import com.meli.futebol.dto.PartidaResponseDTO;
import com.meli.futebol.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partidas")
public class PartidaController {
    @Autowired
    private PartidaService partidaService;

    @PostMapping
    public ResponseEntity<PartidaResponseDTO> cadastrarPartida(@RequestBody PartidaRequestDTO requestDTO) {
        var cadastrarPartida = partidaService.converterESalvarPartidaRequestDTO(requestDTO);
        PartidaResponseDTO responseDTO = partidaService.converterPartidaResponseDTO(cadastrarPartida);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
