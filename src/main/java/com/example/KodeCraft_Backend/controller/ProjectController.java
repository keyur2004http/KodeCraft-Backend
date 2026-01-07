package com.example.KodeCraft_Backend.controller;

import com.example.KodeCraft_Backend.Dto.ProjectResponseDto;
import com.example.KodeCraft_Backend.entity.Project;
import com.example.KodeCraft_Backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public List<ProjectResponseDto> getAllProjectsPublic() {
        return service.getAllPublic();
    }

    @GetMapping("/{slug}")
    public Project getBySlug(@PathVariable String slug) {
        return service.getBySlug(slug);
    }
}
