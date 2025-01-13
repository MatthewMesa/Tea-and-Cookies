package com.teacookies.backend.controllers;

import com.teacookies.backend.models.UserStory;
import com.teacookies.backend.repositories.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userstories")
public class UserStoryController {

    @Autowired
    private UserStoryRepository userStoryRepository;

    @GetMapping
    public List<UserStory> getAllUserStories() {
        return userStoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserStory> getUserStoryById(@PathVariable int id) {
        UserStory userStory = userStoryRepository.findById(id).orElse(null);
        return (userStory != null) ? ResponseEntity.ok(userStory) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public UserStory createUserStory(@RequestBody UserStory userStory) {
        return userStoryRepository.save(userStory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserStory> updateUserStory(@PathVariable int id, @RequestBody UserStory userStory) {
        if (userStoryRepository.existsById(id)) {
            userStory.setCodUS(id);
            return ResponseEntity.ok(userStoryRepository.save(userStory));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserStory(@PathVariable int id) {
        if (userStoryRepository.existsById(id)) {
            userStoryRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
