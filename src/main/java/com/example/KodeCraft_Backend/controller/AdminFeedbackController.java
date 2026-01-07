package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.service.FeedbackStatus;
import com.example.KodeCraft_Backend.entity.Feedback;
import com.example.KodeCraft_Backend.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminFeedbackController {

    private final FeedbackService service;

    public AdminFeedbackController(FeedbackService service) {
        this.service = service;
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return service.getAll();
    }

    @PutMapping("/{id}/approve")
    public Feedback approve(@PathVariable Long id) {
        return service.updateStatus(id, FeedbackStatus.APPROVED);
    }

    @PutMapping("/{id}/reject")
    public Feedback reject(@PathVariable Long id) {
        return service.updateStatus(id, FeedbackStatus.REJECTED);
    }
}
