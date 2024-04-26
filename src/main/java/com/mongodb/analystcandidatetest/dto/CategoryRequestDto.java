package com.mongodb.analystcandidatetest.dto;

import com.mongodb.analystcandidatetest.model.Category;

import java.util.UUID;

public record CategoryRequestDto(
        String title,
        String description,
        UUID ownerId
) {}
