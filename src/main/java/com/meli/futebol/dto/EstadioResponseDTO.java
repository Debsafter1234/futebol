package com.meli.futebol.dto;

import com.meli.futebol.enuns.Estado;
import lombok.Data;

@Data
public class EstadioResponseDTO {
    private Long id;
    private String nome;
    private Estado estado;
    private int quantidadeMaxima;

}
