package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.entity.ServiceItem;
import com.example.KodeCraft_Backend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/services")
@CrossOrigin
public class AdminServiceController {

    @Autowired
    private ServiceRepository repo;


    @PostMapping
    public ServiceItem create(@RequestBody ServiceItem service) {
        return repo.save(service);
    }
    @PutMapping("/{id}")
    public ServiceItem update(@PathVariable Long id,
                              @RequestBody ServiceItem updated) {
        ServiceItem s = repo.findById(id).orElseThrow();
        s.setTitle(updated.getTitle());
        s.setDescription(updated.getDescription());
        s.setIcon(updated.getIcon());
        s.setPosition(updated.getPosition());
        return repo.save(s);
    }
    @GetMapping
    public List<ServiceItem> all() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @PatchMapping("/{id}/toggle")
    public ServiceItem toggle(@PathVariable Long id) {
        ServiceItem s = repo.findById(id).orElseThrow();
        s.setActive(!s.isActive());
        return repo.save(s);
    }
}
