package com.meli.futebol.model;

import com.meli.futebol.enuns.Estado;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clube_casa_id")
    private Clube clubeCasa;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clube_visitante_id")
    private Clube clubeVisitante;
    private int resultadoVisitante;
    private int resultadoCasa;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;
    private LocalDateTime dataPartida;

    public Partida(Clube clubeCasa, Clube clubeVisitante, int resultadoVisitante, int resultadoCasa, Estadio estadio, LocalDateTime dataPartida) {
        this.clubeCasa = clubeCasa;
        this.clubeVisitante = clubeVisitante;
        this.resultadoVisitante = resultadoVisitante;
        this.resultadoCasa = resultadoCasa;
        this.estadio = estadio;
        this.dataPartida = dataPartida;
    }
}







