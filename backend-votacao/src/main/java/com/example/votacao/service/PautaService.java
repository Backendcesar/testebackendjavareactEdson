package com.example.votacao.service;

import com.example.votacao.model.Pauta;
import com.example.votacao.model.Voto;
import com.example.votacao.repository.PautaRepository;
import com.example.votacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private VotoRepository votoRepository;

    public List<Pauta> listarPautas() {
        List<Pauta> pautas = pautaRepository.findAll();
        pautas.forEach(this::calcularResultados);
        return pautas;
    }

    public Pauta buscarPauta(Long id) {
        Pauta pauta = pautaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));
        calcularResultados(pauta);
        return pauta;
    }

    public Pauta criarPauta(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public void votar(Long pautaId, String cpf, String voto) {
        Pauta pauta = buscarPauta(pautaId);
        
        if (!"ABERTA".equals(pauta.getStatus())) {
            throw new RuntimeException("Pauta não está aberta para votação");
        }

        if (votoRepository.existsByPautaIdAndCpf(pautaId, cpf)) {
            throw new RuntimeException("CPF já votou nesta pauta");
        }

        votoRepository.save(new Voto(pautaId, cpf, voto));
    }

    private void calcularResultados(Pauta pauta) {
        pauta.setVotosSim((int) votoRepository.countByPautaIdAndVoto(pauta.getId(), "SIM"));
        pauta.setVotosNao((int) votoRepository.countByPautaIdAndVoto(pauta.getId(), "NAO"));

        if ("ABERTA".equals(pauta.getStatus())) {
            LocalDateTime agora = LocalDateTime.now();
            LocalDateTime fim = pauta.getDataCriacao().plusMinutes(pauta.getTempoSessao());
            
            if (agora.isAfter(fim)) {
                pauta.setStatus("FECHADA");
                pauta.setDataEncerramento(fim);
                pautaRepository.save(pauta);
                pauta.setTempoRestante(0);
            } else {
                pauta.setTempoRestante((int) ChronoUnit.SECONDS.between(agora, fim));
            }
        } else {
            pauta.setTempoRestante(0);
        }
    }
} 