package com.mongodb.analystcandidatetest.dto.category;

import java.util.UUID;

public record CategoryRequestDto(
        String title,
        String description,
        String ownerId
) {}
