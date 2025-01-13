package com.teacookies.backend.controllers;

import com.teacookies.backend.models.InscripcionCursoExamenPregunta;
import com.teacookies.backend.repositories.InscripcionCursoExamenPreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripcion-curso-examen-preguntas")
public class InscripcionCursoExamenPreguntaController {

    @Autowired
    private InscripcionCursoExamenPreguntaRepository repository;

    @GetMapping
    public List<InscripcionCursoExamenPregunta> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionCursoExamenPregunta> getById(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InscripcionCursoExamenPregunta create(@RequestBody InscripcionCursoExamenPregunta entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionCursoExamenPregunta> update(@PathVariable int id, @RequestBody InscripcionCursoExamenPregunta entity) {
        return repository.findById(id)
                .map(existing -> {
                    entity.setId(id);
                    return ResponseEntity.ok(repository.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
