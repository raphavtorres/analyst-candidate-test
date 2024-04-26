package com.mongodb.analystcandidatetest.service.category;

import com.mongodb.analystcandidatetest.dto.CategoryDetail;
import com.mongodb.analystcandidatetest.dto.CategoryRequestDto;
import com.mongodb.analystcandidatetest.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    public CategoryDetail createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category(categoryRequestDto);
        return new CategoryDetail(category);
    }
}
