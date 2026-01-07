package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.entity.ContactMessage;
import com.example.KodeCraft_Backend.repository.ContactMessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
public class MessageController {

    private final ContactMessageRepository repo;

    public MessageController(ContactMessageRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<?> saveMessage(@RequestBody ContactMessage message) {
        repo.save(message);
        return ResponseEntity.ok().build();
    }
}
