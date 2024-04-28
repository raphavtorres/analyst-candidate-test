package com.mongodb.analystcandidatetest.dto.product;

import com.mongodb.analystcandidatetest.model.Category;
import com.mongodb.analystcandidatetest.model.Product;

import java.util.UUID;

public record ProductRequestDto(
        String title,
        String description,
        String ownerId,
        Integer price,
        UUID categoryId
) {
}
