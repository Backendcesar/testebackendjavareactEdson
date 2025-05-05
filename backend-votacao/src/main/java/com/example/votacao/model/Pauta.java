package com.example.votacao.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pauta")
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private String status;

    @Column(name = "tempo_sessao", nullable = false)
    private Integer tempoSessao;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_encerramento")
    private LocalDateTime dataEncerramento;

    @Transient
    private Integer votosSim;

    @Transient
    private Integer votosNao;

    @Transient
    private Integer tempoRestante;

    @PrePersist
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
        status = "ABERTA";
    }
} 