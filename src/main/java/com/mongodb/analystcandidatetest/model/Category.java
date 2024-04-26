package com.mongodb.analystcandidatetest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    private UUID id;
    private String title;
    private String description;
    private UUID ownerId;
}
