package com.mongodb.analystcandidatetest.controller;

import com.mongodb.analystcandidatetest.dto.category.CategoryDetailDto;
import com.mongodb.analystcandidatetest.dto.category.CategoryRequestDto;
import com.mongodb.analystcandidatetest.dto.category.CategoryUpdateDto;
import com.mongodb.analystcandidatetest.model.Category;
import com.mongodb.analystcandidatetest.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDetailDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        CategoryDetailDto categoryDetail = categoryService.createCategory(categoryRequestDto);
        return ResponseEntity.ok().body(categoryDetail);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{idCategory}")
    public ResponseEntity<CategoryDetailDto> updateCategory(@PathVariable UUID idCategory, @RequestBody CategoryUpdateDto categoryUpdateDto) {
        CategoryDetailDto categoryDetailDto = categoryService.updateCategory(idCategory, categoryUpdateDto);
        return ResponseEntity.ok().body(categoryDetailDto);
    }

    @DeleteMapping("/{idCategory}")
    public ResponseEntity deleteCategory(@PathVariable UUID idCategory) {
        categoryService.deleteCategory(idCategory);
        return ResponseEntity.noContent().build();
    }
}
