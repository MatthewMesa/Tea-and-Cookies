package com.teacookies.backend.controllers;

import com.teacookies.backend.models.Clase;
import com.teacookies.backend.repositories.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    @Autowired
    private ClaseRepository claseRepository;

    @GetMapping
    public List<Clase> getAllClases() {
        return claseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clase> getClaseById(@PathVariable int id) {
        Clase clase = claseRepository.findById(id).orElse(null);
        return (clase != null) ? ResponseEntity.ok(clase) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Clase createClase(@RequestBody Clase clase) {
        return claseRepository.save(clase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clase> updateClase(@PathVariable int id, @RequestBody Clase clase) {
        if (claseRepository.existsById(id)) {
            clase.setCodClase(id);
            return ResponseEntity.ok(claseRepository.save(clase));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClase(@PathVariable int id) {
        if (claseRepository.existsById(id)) {
            claseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
