package com.meli.futebol.model;

import com.meli.futebol.enuns.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private String resultado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;
    private LocalDateTime dataPartida;


    public Partida(Clube clubeCasa, Clube clubeVisitante, String resultado, Estadio estadio, LocalDateTime dataPartida) {
        this.clubeCasa = clubeCasa;
        this.clubeVisitante = clubeVisitante;
        this.resultado = resultado;
        this.estadio = estadio;
        this.dataPartida = dataPartida;
    }
}







