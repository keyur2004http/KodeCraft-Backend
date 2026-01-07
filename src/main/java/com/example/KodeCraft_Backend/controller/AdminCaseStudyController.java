package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.entity.CaseStudy;
import com.example.KodeCraft_Backend.repository.CaseStudyRepository;
import com.example.KodeCraft_Backend.repository.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/case-studies")
@CrossOrigin
public class AdminCaseStudyController {

    private final CaseStudyRepository repo;
    private final ProjectRepository projectRepositoryRepo;

    public AdminCaseStudyController(CaseStudyRepository repo, ProjectRepository projectRepositoryRepo) {
        this.repo = repo;
        this.projectRepositoryRepo = projectRepositoryRepo;
    }


    @GetMapping
    public List<CaseStudy> all() {
        return repo.findAll();
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<?> getByProject(@PathVariable Long projectId) {
        return repo.findByProject_Id(projectId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public CaseStudy create(@RequestBody CaseStudy cs) {
        return repo.save(cs);
    }

    @PutMapping("/{id}")
    public CaseStudy update(@PathVariable Long id, @RequestBody CaseStudy cs) {
        cs.setId(id);
        return repo.save(cs);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
