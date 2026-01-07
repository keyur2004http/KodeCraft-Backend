package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.entity.Visitor;
import com.example.KodeCraft_Backend.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/visitors")
public class VisitorAdminController {

    @Autowired
    private VisitorRepository repo;

    @GetMapping
    public List<Visitor> getAll() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "visitTime"));
    }

    @GetMapping("/stats")
    public Map<String, Long> stats() {
        Map<String, Long> map = new HashMap<>();
        map.put("totalVisitors", repo.totalVisitors());
        map.put("activeVisitors",
                repo.activeVisitors(LocalDateTime.now().minusMinutes(5)));
        return map;
    }
}
