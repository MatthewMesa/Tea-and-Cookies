package com.teacookies.backend.controllers;

import com.teacookies.backend.models.CursoExamen;
import com.teacookies.backend.repositories.CursoExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso-examenes")
public class CursoExamenController {

    @Autowired
    private CursoExamenRepository repository;

    @GetMapping
    public List<CursoExamen> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoExamen> getById(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CursoExamen create(@RequestBody CursoExamen entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoExamen> update(@PathVariable int id, @RequestBody CursoExamen entity) {
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
