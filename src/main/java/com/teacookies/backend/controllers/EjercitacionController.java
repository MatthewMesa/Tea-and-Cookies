package com.teacookies.backend.controllers;

import com.teacookies.backend.models.Ejercitacion;
import com.teacookies.backend.repositories.EjercitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercitaciones")
public class EjercitacionController {

    @Autowired
    private EjercitacionRepository ejercitacionRepository;

    @GetMapping
    public List<Ejercitacion> getAllEjercitaciones() {
        return ejercitacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ejercitacion> getEjercitacionById(@PathVariable int id) {
        Ejercitacion ejercitacion = ejercitacionRepository.findById(id).orElse(null);
        return (ejercitacion != null) ? ResponseEntity.ok(ejercitacion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Ejercitacion createEjercitacion(@RequestBody Ejercitacion ejercitacion) {
        return ejercitacionRepository.save(ejercitacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ejercitacion> updateEjercitacion(@PathVariable int id, @RequestBody Ejercitacion ejercitacion) {
        if (ejercitacionRepository.existsById(id)) {
            ejercitacion.setCodEjercitacion(id);
            return ResponseEntity.ok(ejercitacionRepository.save(ejercitacion));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEjercitacion(@PathVariable int id) {
        if (ejercitacionRepository.existsById(id)) {
            ejercitacionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
