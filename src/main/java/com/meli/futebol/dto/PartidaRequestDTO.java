package com.meli.futebol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PartidaRequestDTO {
    private Long clubeCasaId;
    private Long clubeVisitanteId;
    private int resultadoCasa;
    private int resultadoVisitante;
    private String nomeEstadio;
    private LocalDateTime dataHoraPartida;

}
