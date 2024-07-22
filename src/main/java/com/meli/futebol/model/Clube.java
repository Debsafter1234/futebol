package com.meli.futebol.model;


import com.meli.futebol.enuns.Estado;
import com.meli.futebol.enuns.Status;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Estado sede;

}