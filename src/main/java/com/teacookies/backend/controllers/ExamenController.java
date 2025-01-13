package com.teacookies.backend.controllers;

import com.teacookies.backend.models.Examen;
import com.teacookies.backend.repositories.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examenes")
public class ExamenController {

    @Autowired
    private ExamenRepository repository;

    @GetMapping
    public List<Examen> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> getById(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Examen create(@RequestBody Examen entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examen> update(@PathVariable int id, @RequestBody Examen entity) {
        return repository.findById(id)
                .map(existing -> {
                    entity.setCodExamen(id);
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
