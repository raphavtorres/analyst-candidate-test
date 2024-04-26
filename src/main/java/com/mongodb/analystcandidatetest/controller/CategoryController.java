package com.mongodb.analystcandidatetest.controller;

import com.mongodb.analystcandidatetest.dto.CategoryDetail;
import com.mongodb.analystcandidatetest.dto.CategoryRequestDto;
import com.mongodb.analystcandidatetest.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDetail> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        CategoryDetail categoryDetail = categoryService.createCategory(categoryRequestDto);
        return ResponseEntity.ok().body(categoryDetail);
    }
    
}
