package com.meli.futebol.model;

import com.meli.futebol.enuns.Estado;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Column(name = "QUANTIDADEMAXIMA")
    private int quantidadeMaxima;
}
