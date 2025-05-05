package com.example.votacao.controller;

import com.example.votacao.model.Pauta;
import com.example.votacao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/pautas")
@CrossOrigin(originPatterns = "http://localhost:3000", allowCredentials = "true")
public class PautaController {

    private static final Logger logger = LoggerFactory.getLogger(PautaController.class);

    @Autowired
    private PautaService pautaService;

    @GetMapping
    public ResponseEntity<List<Pauta>> listarPautas() {
        try {
            logger.info("Recebida requisição para listar pautas");
            List<Pauta> pautas = pautaService.listarPautas();
            logger.info("Pautas encontradas: {}", pautas.size());
            return ResponseEntity.ok(pautas);
        } catch (Exception e) {
            logger.error("Erro ao listar pautas", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pauta> buscarPauta(@PathVariable Long id) {
        try {
            logger.info("Recebida requisição para buscar pauta com ID: {}", id);
            Pauta pauta = pautaService.buscarPauta(id);
            return ResponseEntity.ok(pauta);
        } catch (Exception e) {
            logger.error("Erro ao buscar pauta com ID: {}", id, e);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Pauta> criarPauta(@RequestBody Pauta pauta) {
        try {
            logger.info("Recebida requisição para criar nova pauta");
            Pauta novaPauta = pautaService.criarPauta(pauta);
            return ResponseEntity.ok(novaPauta);
        } catch (Exception e) {
            logger.error("Erro ao criar pauta", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}/votos")
    public ResponseEntity<Void> votar(@PathVariable Long id, @RequestBody VotoRequest voto) {
        try {
            logger.info("Recebida requisição para votar na pauta ID: {}", id);
            pautaService.votar(id, voto.getCpf(), voto.getVoto());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao registrar voto na pauta ID: {}", id, e);
            return ResponseEntity.badRequest().build();
        }
    }
} 