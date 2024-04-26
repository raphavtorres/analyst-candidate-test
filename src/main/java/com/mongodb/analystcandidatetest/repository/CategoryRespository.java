package com.mongodb.analystcandidatetest.repository;

import com.mongodb.analystcandidatetest.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CategoryRespository extends MongoRepository<Category, UUID> {
}
