package com.meli.futebol.controller;

import com.meli.futebol.dto.BaseResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClubeAdvice {

    @ExceptionHandler(ExeptionPersonalizada.class)
    public ResponseEntity<BaseResponseDTO> exeptionPersonalizada(ExeptionPersonalizada ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(new BaseResponseDTO(ex.getStatus(), "erro", ex.getMessage()));
    }
}
///estou fazendo teste