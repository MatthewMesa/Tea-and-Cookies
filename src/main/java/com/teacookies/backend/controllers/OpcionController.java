package com.teacookies.backend.controllers;

import com.teacookies.backend.models.Opcion;
import com.teacookies.backend.repositories.OpcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opciones")
public class OpcionController {

    @Autowired
    private OpcionRepository opcionRepository;

    @GetMapping
    public List<Opcion> getAllOpciones() {
        return opcionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opcion> getOpcionById(@PathVariable int id) {
        Opcion opcion = opcionRepository.findById(id).orElse(null);
        return (opcion != null) ? ResponseEntity.ok(opcion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Opcion createOpcion(@RequestBody Opcion opcion) {
        return opcionRepository.save(opcion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Opcion> updateOpcion(@PathVariable int id, @RequestBody Opcion opcion) {
        if (opcionRepository.existsById(id)) {
            opcion.setCodOpcion(id);
            return ResponseEntity.ok(opcionRepository.save(opcion));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpcion(@PathVariable int id) {
        if (opcionRepository.existsById(id)) {
            opcionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
