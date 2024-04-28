package com.mongodb.analystcandidatetest.infra.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
        super("Category doesn't exists!");
    }

}
