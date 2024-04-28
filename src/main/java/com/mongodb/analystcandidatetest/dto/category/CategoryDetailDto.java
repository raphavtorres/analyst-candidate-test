package com.mongodb.analystcandidatetest.dto.category;

import com.mongodb.analystcandidatetest.model.Category;

import java.util.UUID;

public record CategoryDetailDto(
        UUID id,
        String title,
        String description,
        String ownerId
) {
    public CategoryDetailDto(Category category) {
        this(category.getId(), category.getTitle(), category.getDescription(), category.getOwnerId());
    }
}
