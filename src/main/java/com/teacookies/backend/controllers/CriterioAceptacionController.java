package com.teacookies.backend.controllers;

import com.teacookies.backend.models.CriterioAceptacion;
import com.teacookies.backend.repositories.CriterioAceptacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/criterios-aceptacion")
public class CriterioAceptacionController {

    @Autowired
    private CriterioAceptacionRepository criterioAceptacionRepository;

    @GetMapping
    public List<CriterioAceptacion> getAllCriteriosAceptacion() {
        return criterioAceptacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriterioAceptacion> getCriterioAceptacionById(@PathVariable int id) {
        CriterioAceptacion criterio = criterioAceptacionRepository.findById(id).orElse(null);
        return (criterio != null) ? ResponseEntity.ok(criterio) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CriterioAceptacion createCriterioAceptacion(@RequestBody CriterioAceptacion criterio) {
        return criterioAceptacionRepository.save(criterio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriterioAceptacion> updateCriterioAceptacion(@PathVariable int id, @RequestBody CriterioAceptacion criterio) {
        if (criterioAceptacionRepository.existsById(id)) {
            criterio.setCodCriterioAceptacion(id);
            return ResponseEntity.ok(criterioAceptacionRepository.save(criterio));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCriterioAceptacion(@PathVariable int id) {
        if (criterioAceptacionRepository.existsById(id)) {
            criterioAceptacionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
