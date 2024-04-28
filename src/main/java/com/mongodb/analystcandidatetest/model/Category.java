package com.mongodb.analystcandidatetest.model;

import com.mongodb.analystcandidatetest.dto.category.CategoryRequestDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    private UUID id;
    private String title;
    private String description;
    private String ownerId;

    public Category(CategoryRequestDto categoryRequestDto) {
        this.title = categoryRequestDto.title();
        this.description = categoryRequestDto.description();
        this.ownerId = categoryRequestDto.ownerId();
    }
}
