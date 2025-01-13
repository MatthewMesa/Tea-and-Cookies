package com.teacookies.backend.controllers;

import com.teacookies.backend.models.TipoPregunta;
import com.teacookies.backend.repositories.TipoPreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-preguntas")
public class TipoPreguntaController {

    @Autowired
    private TipoPreguntaRepository tipoPreguntaRepository;

    @GetMapping
    public List<TipoPregunta> getAllTipoPreguntas() {
        return tipoPreguntaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPregunta> getTipoPreguntaById(@PathVariable int id) {
        TipoPregunta tipoPregunta = tipoPreguntaRepository.findById(id).orElse(null);
        return (tipoPregunta != null) ? ResponseEntity.ok(tipoPregunta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TipoPregunta createTipoPregunta(@RequestBody TipoPregunta tipoPregunta) {
        return tipoPreguntaRepository.save(tipoPregunta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPregunta> updateTipoPregunta(@PathVariable int id, @RequestBody TipoPregunta tipoPregunta) {
        if (tipoPreguntaRepository.existsById(id)) {
            tipoPregunta.setCodTipoPregunta(id);
            return ResponseEntity.ok(tipoPreguntaRepository.save(tipoPregunta));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPregunta(@PathVariable int id) {
        if (tipoPreguntaRepository.existsById(id)) {
            tipoPreguntaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
