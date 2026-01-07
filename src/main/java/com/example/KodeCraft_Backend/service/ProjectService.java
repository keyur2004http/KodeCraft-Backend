package com.example.KodeCraft_Backend.service;

import com.example.KodeCraft_Backend.Dto.ProjectResponseDto;
import com.example.KodeCraft_Backend.entity.Project;
import com.example.KodeCraft_Backend.entity.ProjectTag;
import com.example.KodeCraft_Backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    public List<ProjectResponseDto> getAllForAdmin() {
        return projectRepo.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .stream()
                .map(this::mapToDto)
                .toList();
    }
    public List<ProjectResponseDto> getAllPublic() {
        return projectRepo.findByLiveTrueOrderByIdDesc()
                .stream()
                .map(this::mapToDto)
                .toList();
    }


    public Project getBySlug(String slug) {
        return projectRepo.findBySlug(slug)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }
    private ProjectResponseDto mapToDto(Project project) {

        ProjectResponseDto dto = new ProjectResponseDto();
        dto.id=project.getId();
        dto.slug = project.getSlug();
        dto.title = project.getTitle();
        dto.description = project.getDescription();
        dto.link = project.getLink();
        dto.live = project.isLive();

        // ✅ Tags (ProjectTag → String)
        dto.tags = project.getTags()
                .stream()
                .map(ProjectTag::getTag)
                .toList();

        // ✅ Images (merge imageUrl + imageUrl2)
        List<String> images = new ArrayList<>();
        if (project.getImageUrl() != null && !project.getImageUrl().isBlank()) {
            images.add(project.getImageUrl());
        }
        if (project.getImageUrl2() != null && !project.getImageUrl2().isBlank()) {
            images.add(project.getImageUrl2());
        }
        dto.images = images;
        dto.caseStudy = project.getCaseStudy();
        return dto;
    }

}
