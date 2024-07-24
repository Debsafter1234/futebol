package com.meli.futebol.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PartidaResponseDTO {
    private Long id;
    private String clubeCasaNome;
    private String clubeVisitanteNome;
    private int resultadoCasa;
    private int resultadoVisitante;
    private String estadio;
    private LocalDateTime dataHora;

}
