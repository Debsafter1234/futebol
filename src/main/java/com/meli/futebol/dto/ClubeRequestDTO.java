package com.meli.futebol.dto;

import com.meli.futebol.enuns.Estado;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClubeRequestDTO {
    private String nome;
    private LocalDate dataCriacao;
    private Estado sede;
}
