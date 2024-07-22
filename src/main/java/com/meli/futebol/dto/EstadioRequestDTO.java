package com.meli.futebol.dto;

import com.meli.futebol.enuns.Estado;
import lombok.Data;

@Data
public class EstadioRequestDTO {
        private String nome;
        private Estado estado;
        private int quantidadeMaxima;
}
