package com.teacookies.backend.controllers;

import com.teacookies.backend.models.Epic;
import com.teacookies.backend.repositories.EpicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/epics")
public class EpicController {

    @Autowired
    private EpicRepository epicRepository;

    @GetMapping
    public List<Epic> getAllEpics() {
        return epicRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Epic> getEpicById(@PathVariable int id) {
        Epic epic = epicRepository.findById(id).orElse(null);
        return (epic != null) ? ResponseEntity.ok(epic) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Epic createEpic(@RequestBody Epic epic) {
        return epicRepository.save(epic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Epic> updateEpic(@PathVariable int id, @RequestBody Epic epic) {
        if (epicRepository.existsById(id)) {
            epic.setCodEpic(id);
            return ResponseEntity.ok(epicRepository.save(epic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpic(@PathVariable int id) {
        if (epicRepository.existsById(id)) {
            epicRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
