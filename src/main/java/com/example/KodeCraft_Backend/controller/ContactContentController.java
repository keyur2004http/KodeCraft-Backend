package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.entity.ContactPageContent;
import com.example.KodeCraft_Backend.repository.ContactPageContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact/content")
@CrossOrigin
public class ContactContentController {

    @Autowired
    private ContactPageContentRepository repo;

    @GetMapping
    public ContactPageContent getContent() {
        return repo.findById(1L).orElse(null);
    }
}
