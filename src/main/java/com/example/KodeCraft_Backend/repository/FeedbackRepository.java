package com.example.KodeCraft_Backend.repository;

import com.example.KodeCraft_Backend.entity.Feedback;
import com.example.KodeCraft_Backend.service.FeedbackStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository
        extends JpaRepository<Feedback, Long> {
    List<Feedback> findTop3ByStatusOrderByCreatedAtDesc(FeedbackStatus status);
}
