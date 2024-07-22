package com.meli.futebol.controller;

import com.meli.futebol.dto.BaseResponseDTO;
import com.meli.futebol.dto.ClubeRequestDTO;
import com.meli.futebol.service.ClubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estadio")
public class EstadioController {


//TODO: implementar os endpoints de Estadio


    @Autowired
    private ClubeService clubeService;

    @PostMapping
    public ResponseEntity<BaseResponseDTO> salvar(@RequestBody ClubeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new BaseResponseDTO(HttpStatus.CREATED.value(), "sucesso", clubeService.cadastrar(dto)));


    }

    @PutMapping
    public ResponseEntity<BaseResponseDTO> editar(@RequestBody ClubeRequestDTO dto, @RequestParam long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new BaseResponseDTO(HttpStatus.OK.value(), "sucesso", clubeService.editar(dto, id)));


    }

    @DeleteMapping
    public ResponseEntity<BaseResponseDTO> inativar(@RequestParam long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new BaseResponseDTO(HttpStatus.OK.value(), "sucesso", clubeService.inativarClube(id)));

    }

    @GetMapping
    public ResponseEntity<BaseResponseDTO> buscarPorId(@RequestParam long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new BaseResponseDTO(HttpStatus.OK.value(), "sucesso", clubeService.buscarCluberPorId(id)));

    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponseDTO> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new BaseResponseDTO(HttpStatus.OK.value(), "sucesso", clubeService.buscarTodos()));

    }
}
