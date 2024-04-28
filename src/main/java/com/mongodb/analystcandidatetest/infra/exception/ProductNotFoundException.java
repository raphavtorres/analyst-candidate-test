package com.mongodb.analystcandidatetest.infra.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Product doesn't exists!");
    }
}
