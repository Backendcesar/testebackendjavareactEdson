package com.example.votacao.controller;

import com.example.votacao.dto.UsuarioDTO;
import com.example.votacao.model.Usuario;
import com.example.votacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(usuarioDTO.getNome());
            usuario.setCpf(usuarioDTO.getCpf());
            usuario.setSenha(usuarioDTO.getSenha());
            return ResponseEntity.ok(usuarioService.registrarUsuario(usuario));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable String cpf) {
        try {
            return ResponseEntity.ok(usuarioService.buscarPorCpf(cpf));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
} 