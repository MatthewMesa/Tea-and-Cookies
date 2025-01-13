package com.teacookies.backend.controllers;

import com.teacookies.backend.models.EstadoInscripcionCurso;
import com.teacookies.backend.repositories.EstadoInscripcionCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados-inscripcion")
public class EstadoInscripcionCursoController {

    @Autowired
    private EstadoInscripcionCursoRepository estadoInscripcionCursoRepository;

    @GetMapping
    public List<EstadoInscripcionCurso> getAllEstadosInscripcion() {
        return estadoInscripcionCursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoInscripcionCurso> getEstadoInscripcionById(@PathVariable int id) {
        EstadoInscripcionCurso estadoInscripcionCurso = estadoInscripcionCursoRepository.findById(id).orElse(null);
        return (estadoInscripcionCurso != null) ? ResponseEntity.ok(estadoInscripcionCurso) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public EstadoInscripcionCurso createEstadoInscripcion(@RequestBody EstadoInscripcionCurso estadoInscripcionCurso) {
        return estadoInscripcionCursoRepository.save(estadoInscripcionCurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoInscripcionCurso> updateEstadoInscripcion(@PathVariable int id, @RequestBody EstadoInscripcionCurso estadoInscripcionCurso) {
        if (estadoInscripcionCursoRepository.existsById(id)) {
            estadoInscripcionCurso.setCodEstadoInscripcionCurso(id);
            return ResponseEntity.ok(estadoInscripcionCursoRepository.save(estadoInscripcionCurso));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoInscripcion(@PathVariable int id) {
        if (estadoInscripcionCursoRepository.existsById(id)) {
            estadoInscripcionCursoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
