package com.example.votacao.repository;

import com.example.votacao.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    boolean existsByPautaIdAndCpf(Long pautaId, String cpf);
    long countByPautaIdAndVoto(Long pautaId, String voto);
} 