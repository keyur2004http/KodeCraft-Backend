package com.example.KodeCraft_Backend.repository;

import com.example.KodeCraft_Backend.entity.CaseStudy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaseStudyRepository extends JpaRepository<CaseStudy, Long> {
    Optional<CaseStudy> findBySlug(String slug);

    Optional<CaseStudy> findByProject_Id(Long projectId);
}
