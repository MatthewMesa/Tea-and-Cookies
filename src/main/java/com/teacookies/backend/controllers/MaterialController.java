package com.teacookies.backend.controllers;

import com.teacookies.backend.models.Material;
import com.teacookies.backend.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping
    public List<Material> getAllMateriales() {
        return materialRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable int id) {
        Material material = materialRepository.findById(id).orElse(null);
        return (material != null) ? ResponseEntity.ok(material) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Material createMaterial(@RequestBody Material material) {
        return materialRepository.save(material);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable int id, @RequestBody Material material) {
        if (materialRepository.existsById(id)) {
            material.setCodMaterial(id);
            return ResponseEntity.ok(materialRepository.save(material));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable int id) {
        if (materialRepository.existsById(id)) {
            materialRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
