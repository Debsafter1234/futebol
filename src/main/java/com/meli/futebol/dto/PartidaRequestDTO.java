package com.meli.futebol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PartidaRequestDTO {
    private Long clubeCasaId;
    private Long clubeVisitanteId;
    private String clubeCasaNome;
    private String clubeVisitanteNome;
    private String resultado;
    private String nomeEstadio;
    private LocalDateTime dataHoraPartida;

}
