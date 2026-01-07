package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.Dto.ProjectRequest;
import com.example.KodeCraft_Backend.Dto.ProjectResponseDto;
import com.example.KodeCraft_Backend.entity.Project;
import com.example.KodeCraft_Backend.entity.ProjectTag;
import com.example.KodeCraft_Backend.repository.ProjectRepository;
import com.example.KodeCraft_Backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/projects")
@CrossOrigin
public class AdminProjectController {

    @Autowired
    private ProjectRepository repo;
    @Autowired
    private ProjectService service;

    @GetMapping
    public List<ProjectResponseDto> getAllProjectsAdmin() {
        return service.getAllForAdmin();
    }

    @PostMapping
    public Project create(@RequestBody ProjectRequest req) {

        Project project = new Project();
        project.setTitle(req.getTitle());
        project.setSlug(req.getSlug());
        project.setDescription(req.getDescription());
        project.setLink(req.getLink());
        project.setLive(req.isLive());
        project.setImageUrl(req.getImageUrl());
        project.setImageUrl2(req.getImageUrl2());

        // 🔥 TAG HANDLING
        if (req.getTags() != null) {
            for (String tagName : req.getTags()) {
                ProjectTag tag = new ProjectTag();
                tag.setTag(tagName);
                tag.setProject(project);
                project.getTags().add(tag);
            }
        }
        return repo.save(project);
    }
    @PutMapping("/{id}")
    public Project update(@PathVariable Long id,
                          @RequestBody Project p) {
        p.setId(id);
        return repo.save(p);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
