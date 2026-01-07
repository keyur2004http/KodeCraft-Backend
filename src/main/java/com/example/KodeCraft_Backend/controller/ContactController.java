package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.entity.ContactMessage;
import com.example.KodeCraft_Backend.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {

    @Autowired
    private ContactMessageRepository repo;

    @PostMapping
    public void saveMessage(@RequestBody ContactMessage message) {
        message.setSource("contact-page");
        repo.save(message);
    }
}
