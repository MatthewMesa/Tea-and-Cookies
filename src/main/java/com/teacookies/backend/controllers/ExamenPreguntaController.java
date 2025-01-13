package com.teacookies.backend.controllers;

import com.teacookies.backend.models.ExamenPregunta;
import com.teacookies.backend.repositories.ExamenPreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examen-preguntas")
public class ExamenPreguntaController {

    @Autowired
    private ExamenPreguntaRepository examenPreguntaRepository;

    @GetMapping
    public List<ExamenPregunta> getAllExamenPreguntas() {
        return examenPreguntaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamenPregunta> getExamenPreguntaById(@PathVariable int id) {
        ExamenPregunta examenPregunta = examenPreguntaRepository.findById(id).orElse(null);
        return (examenPregunta != null) ? ResponseEntity.ok(examenPregunta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ExamenPregunta createExamenPregunta(@RequestBody ExamenPregunta examenPregunta) {
        return examenPreguntaRepository.save(examenPregunta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamenPregunta> updateExamenPregunta(@PathVariable int id, @RequestBody ExamenPregunta examenPregunta) {
        if (examenPreguntaRepository.existsById(id)) {
            examenPregunta.setOrdenPregunta(id);
            return ResponseEntity.ok(examenPreguntaRepository.save(examenPregunta));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamenPregunta(@PathVariable int id) {
        if (examenPreguntaRepository.existsById(id)) {
            examenPreguntaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
