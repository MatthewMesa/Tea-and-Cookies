package com.teacookies.backend.controllers;

import com.teacookies.backend.models.InscripcionCurso;
import com.teacookies.backend.repositories.InscripcionCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionCursoController {

    @Autowired
    private InscripcionCursoRepository repository;

    @GetMapping
    public List<InscripcionCurso> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionCurso> getById(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InscripcionCurso create(@RequestBody InscripcionCurso entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionCurso> update(@PathVariable int id, @RequestBody InscripcionCurso entity) {
        return repository.findById(id)
                .map(existing -> {
                    entity.setNumeroInscripcion(id);
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
