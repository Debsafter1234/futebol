package com.meli.futebol.exeption;

import com.meli.futebol.dto.BaseResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {

    @ExceptionHandler(ExeptionPersonalizada.class)
    public ResponseEntity<BaseResponseDTO> exeptionPersonalizada(ExeptionPersonalizada ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(new BaseResponseDTO(ex.getStatus(), "erro", ex.getMessage()));
    }
}
