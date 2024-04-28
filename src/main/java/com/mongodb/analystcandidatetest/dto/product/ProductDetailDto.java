package com.mongodb.analystcandidatetest.dto.product;

import com.mongodb.analystcandidatetest.model.Category;
import com.mongodb.analystcandidatetest.model.Product;

import java.util.UUID;

public record ProductDetailDto(
        UUID id,
        String title,
        String description,
        String ownerId,
        Integer price,
        UUID categoryId
) {
    public ProductDetailDto(Product product) {
        this(product.getId(), product.getTitle(), product.getDescription(), product.getOwnerId(), product.getPrice(), product.getCategory().getId());
    }
}