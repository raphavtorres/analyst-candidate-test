package com.mongodb.analystcandidatetest.dto;

import com.mongodb.analystcandidatetest.model.Category;

import java.util.UUID;

public record CategoryDetail(
        UUID id,
        String title,
        String description,
        UUID ownerId
) {
    public CategoryDetail(Category category) {
        this(category.getId(), category.getTitle(), category.getDescription(), category.getOwnerId());
    }
}
