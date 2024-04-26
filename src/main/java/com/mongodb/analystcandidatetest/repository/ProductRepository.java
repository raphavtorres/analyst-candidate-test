package com.mongodb.analystcandidatetest.repository;

import com.mongodb.analystcandidatetest.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, UUID> {
}
