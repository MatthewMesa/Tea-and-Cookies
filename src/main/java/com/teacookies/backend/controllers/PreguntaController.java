package com.teacookies.backend.controllers;

import com.teacookies.backend.models.Pregunta;
import com.teacookies.backend.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @GetMapping
    public List<Pregunta> getAllPreguntas() {
        return preguntaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> getPreguntaById(@PathVariable int id) {
        Pregunta pregunta = preguntaRepository.findById(id).orElse(null);
        return (pregunta != null) ? ResponseEntity.ok(pregunta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Pregunta createPregunta(@RequestBody Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pregunta> updatePregunta(@PathVariable int id, @RequestBody Pregunta pregunta) {
        if (preguntaRepository.existsById(id)) {
            pregunta.setCodPregunta(id);
            return ResponseEntity.ok(preguntaRepository.save(pregunta));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregunta(@PathVariable int id) {
        if (preguntaRepository.existsById(id)) {
            preguntaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
