package com.teacookies.backend.controllers;

import com.teacookies.backend.models.TipoUsuario;
import com.teacookies.backend.repositories.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-usuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping
    public List<TipoUsuario> getAllTiposUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> getTipoUsuarioById(@PathVariable int id) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(id).orElse(null);
        return (tipoUsuario != null) ? ResponseEntity.ok(tipoUsuario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TipoUsuario createTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> updateTipoUsuario(@PathVariable int id, @RequestBody TipoUsuario tipoUsuario) {
        if (tipoUsuarioRepository.existsById(id)) {
            tipoUsuario.setCodTipoUsuario(id);
            return ResponseEntity.ok(tipoUsuarioRepository.save(tipoUsuario));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoUsuario(@PathVariable int id) {
        if (tipoUsuarioRepository.existsById(id)) {
            tipoUsuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
