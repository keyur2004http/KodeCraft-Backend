package com.example.KodeCraft_Backend.Dto;

import com.example.KodeCraft_Backend.entity.CaseStudy;

import java.util.List;

public class ProjectResponseDto {
    public Long id;
    public String slug;
    public String title;
    public String description;
    public String link;
    public boolean live;
    public List<String> tags;
    public List<String> images;
    public CaseStudy caseStudy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CaseStudy getCaseStudy() {
        return caseStudy;
    }

    public void setCaseStudy(CaseStudy caseStudy) {
        this.caseStudy = caseStudy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
