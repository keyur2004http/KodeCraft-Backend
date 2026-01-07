package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.entity.Feedback;
import com.example.KodeCraft_Backend.service.FeedbackService;
import com.example.KodeCraft_Backend.service.FeedbackStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    // Public – submit feedback
    @PostMapping("/feedback")
    public Feedback submit(@RequestBody Feedback feedback) {
        feedback.setStatus(FeedbackStatus.PENDING);
        feedback.setCreatedAt(LocalDateTime.now());
        return service.save(feedback);
    }
    @GetMapping("/testimonials")
    public List<Feedback> getTestimonials() {
        return service.getLatestApproved();
    }

}
