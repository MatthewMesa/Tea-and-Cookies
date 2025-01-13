package com.teacookies.backend.controllers;

import com.teacookies.backend.models.InscripcionCursoExamen;
import com.teacookies.backend.repositories.InscripcionCursoExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripcion-curso-examenes")
public class InscripcionCursoExamenController {

    @Autowired
    private InscripcionCursoExamenRepository repository;

    @GetMapping
    public List<InscripcionCursoExamen> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionCursoExamen> getById(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InscripcionCursoExamen create(@RequestBody InscripcionCursoExamen entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionCursoExamen> update(@PathVariable int id, @RequestBody InscripcionCursoExamen entity) {
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
