package com.example.KodeCraft_Backend.service;

import com.example.KodeCraft_Backend.entity.Feedback;
import com.example.KodeCraft_Backend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public List<Feedback> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public Feedback updateStatus(Long id, FeedbackStatus status) {
        Feedback feedback = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        feedback.setStatus(status);
        return repository.save(feedback);
    }
    public Feedback save(Feedback feedback) {
        return repository.save(feedback);
    }
    public List<Feedback> getLatestApproved() {
        return repository.findTop3ByStatusOrderByCreatedAtDesc(FeedbackStatus.APPROVED);
    }


}
