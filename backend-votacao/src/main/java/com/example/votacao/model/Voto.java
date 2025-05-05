package com.example.votacao.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "voto")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pauta_id", nullable = false)
    private Long pautaId;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 3)
    private String voto;

    @Column(name = "data_voto", nullable = false)
    private LocalDateTime dataVoto;

    public Voto() {
        this.dataVoto = LocalDateTime.now();
    }

    public Voto(Long pautaId, String cpf, String voto) {
        this.pautaId = pautaId;
        this.cpf = cpf;
        this.voto = voto;
        this.dataVoto = LocalDateTime.now();
    }
} 