package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.entity.ContactPageContent;
import com.example.KodeCraft_Backend.repository.ContactPageContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/contact/content")
@CrossOrigin
public class AdminContactContentController {

    @Autowired
    private ContactPageContentRepository repo;

    @PutMapping
    public ContactPageContent update(@RequestBody ContactPageContent content) {
        content.setId(1L); // always update same row
        return repo.save(content);
    }
}
