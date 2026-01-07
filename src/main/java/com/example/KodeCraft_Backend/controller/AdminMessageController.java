package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.entity.ContactMessage;
import com.example.KodeCraft_Backend.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/messages")
@CrossOrigin
public class AdminMessageController {

    @Autowired
    private ContactMessageRepository repo;

    @GetMapping
    public List<ContactMessage> getAll() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @PatchMapping("/{id}/read")
    public ContactMessage markRead(@PathVariable Long id) {
        ContactMessage msg = repo.findById(id).orElseThrow();
        msg.setReadStatus(true);
        return repo.save(msg);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
