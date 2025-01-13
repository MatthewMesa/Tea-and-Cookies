package com.teacookies.backend.controllers;

import com.teacookies.backend.models.TipoClase;
import com.teacookies.backend.repositories.TipoClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-clase")
public class TipoClaseController {

    @Autowired
    private TipoClaseRepository tipoClaseRepository;

    @GetMapping
    public List<TipoClase> getAllTiposClase() {
        return tipoClaseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoClase> getTipoClaseById(@PathVariable int id) {
        TipoClase tipoClase = tipoClaseRepository.findById(id).orElse(null);
        return (tipoClase != null) ? ResponseEntity.ok(tipoClase) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TipoClase createTipoClase(@RequestBody TipoClase tipoClase) {
        return tipoClaseRepository.save(tipoClase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoClase> updateTipoClase(@PathVariable int id, @RequestBody TipoClase tipoClase) {
        if (tipoClaseRepository.existsById(id)) {
            tipoClase.setCodTipoClase(id);
            return ResponseEntity.ok(tipoClaseRepository.save(tipoClase));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoClase(@PathVariable int id) {
        if (tipoClaseRepository.existsById(id)) {
            tipoClaseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
