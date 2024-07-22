package com.meli.futebol.dto;

import com.meli.futebol.enuns.Estado;
import com.meli.futebol.enuns.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClubeResponseDTO {
    private long id;
    private String nome;
    private Status status;
    private LocalDate dataCriacao;
    private Estado sede;
}

