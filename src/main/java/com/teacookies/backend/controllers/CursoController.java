package com.teacookies.backend.controllers;

import com.teacookies.backend.models.Curso;
import com.teacookies.backend.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<Curso> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Curso create(@RequestBody Curso entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable int id, @RequestBody Curso entity) {
        return repository.findById(id)
                .map(existing -> {
                    entity.setCodCurso((long) id);
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
