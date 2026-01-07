package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/dashboard")
public class DashboardController {

    @Autowired
    VisitorRepository visitors;
    @Autowired
    ContactMessageRepository messages;
    @Autowired
    FeedbackRepository feedback;
    @Autowired
    ServiceRepository services;
    @Autowired
    ProjectRepository projects;

    @GetMapping("/stats")
    public Map<String, Long> stats() {
        Map<String, Long> map = new HashMap<>();
        map.put("totalVisitors", visitors.count());
        map.put("activeVisitors",
                visitors.activeVisitors(LocalDateTime.now().minusMinutes(5)));
        map.put("totalMessages", messages.count());
        map.put("totalFeedback", feedback.count());
        map.put("totalServices", services.count());
        map.put("totalProjects", projects.count());
        return map;
    }
}
