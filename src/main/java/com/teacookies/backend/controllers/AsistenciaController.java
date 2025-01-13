package com.teacookies.backend.controllers;

import com.teacookies.backend.models.Asistencia;
import com.teacookies.backend.repositories.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @GetMapping
    public List<Asistencia> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> getAsistenciaById(@PathVariable int id) {
        Asistencia asistencia = asistenciaRepository.findById(id).orElse(null);
        return (asistencia != null) ? ResponseEntity.ok(asistencia) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Asistencia createAsistencia(@RequestBody Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> updateAsistencia(@PathVariable int id, @RequestBody Asistencia asistencia) {
        if (asistenciaRepository.existsById(id)) {
            asistencia.setCodAsistencia(id);
            return ResponseEntity.ok(asistenciaRepository.save(asistencia));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsistencia(@PathVariable int id) {
        if (asistenciaRepository.existsById(id)) {
            asistenciaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
