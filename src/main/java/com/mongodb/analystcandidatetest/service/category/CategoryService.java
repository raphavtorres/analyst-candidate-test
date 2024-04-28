package com.mongodb.analystcandidatetest.service.category;

import com.mongodb.analystcandidatetest.dto.category.CategoryDetailDto;
import com.mongodb.analystcandidatetest.dto.category.CategoryRequestDto;
import com.mongodb.analystcandidatetest.dto.category.CategoryUpdateDto;
import com.mongodb.analystcandidatetest.infra.exception.CategoryNotFoundException;
import com.mongodb.analystcandidatetest.model.Category;
import com.mongodb.analystcandidatetest.repository.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;

    @Transactional
    public CategoryDetailDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category(categoryRequestDto);
        categoryRespository.save(category);
        return new CategoryDetailDto(category);
    }

    public List<Category> getAllCategories() {
        return categoryRespository.findAll();
    }

    public Optional<Category> getCategoryById(UUID categoryId) {
        return categoryRespository.findById(categoryId);
    }

    @Transactional
    public CategoryDetailDto updateCategory(UUID idCategory, CategoryUpdateDto categoryUpdateDto) {
        Category category = categoryRespository.findById(idCategory)
                .orElseThrow(CategoryNotFoundException::new);

        if (!categoryUpdateDto.title().isEmpty()) category.setTitle(categoryUpdateDto.title());
        if (!categoryUpdateDto.description().isEmpty()) category.setDescription(categoryUpdateDto.description());

        return new CategoryDetailDto(category);
    }

    @Transactional
    public void deleteCategory(UUID idCategory) {
        Category category = categoryRespository.findById(idCategory).orElseThrow(CategoryNotFoundException::new);
        categoryRespository.delete(category);
    }
}
