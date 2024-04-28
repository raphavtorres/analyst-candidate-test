package com.mongodb.analystcandidatetest.dto.product;

import com.mongodb.analystcandidatetest.model.Category;

import java.util.UUID;

public record ProductUpdateDto(
        String title,
        String description,
        String ownerId,
        Integer price,
        UUID categoryId
) {
}
