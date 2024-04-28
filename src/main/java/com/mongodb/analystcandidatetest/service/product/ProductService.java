package com.mongodb.analystcandidatetest.service.product;

import com.mongodb.analystcandidatetest.dto.product.ProductDetailDto;
import com.mongodb.analystcandidatetest.dto.product.ProductRequestDto;
import com.mongodb.analystcandidatetest.dto.product.ProductUpdateDto;
import com.mongodb.analystcandidatetest.infra.exception.CategoryNotFoundException;
import com.mongodb.analystcandidatetest.infra.exception.ProductNotFoundException;
import com.mongodb.analystcandidatetest.model.Category;
import com.mongodb.analystcandidatetest.model.Product;
import com.mongodb.analystcandidatetest.repository.ProductRepository;
import com.mongodb.analystcandidatetest.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRespository;

    @Autowired
    private CategoryService categoryService;

    @Transactional
    public ProductDetailDto createProduct(ProductRequestDto productRequestDto) {
        Category category = categoryService.getCategoryById(productRequestDto.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        Product product = new Product(productRequestDto);
        product.setCategory(category);
        productRespository.save(product);
        return new ProductDetailDto(product);
    }

    public List<Product> getAllProducts() {
        return productRespository.findAll();
    }

    @Transactional
    public ProductDetailDto updateProduct(UUID idProduct, ProductUpdateDto productUpdateDto) {
        Product product = productRespository.findById(idProduct)
                .orElseThrow(ProductNotFoundException::new);

        categoryService.getCategoryById(productUpdateDto.categoryId()).ifPresent(product::setCategory);

        if (!productUpdateDto.title().isEmpty()) product.setTitle(productUpdateDto.title());
        if (!productUpdateDto.description().isEmpty()) product.setDescription(productUpdateDto.description());
        if (!(productUpdateDto.price() == null)) product.setPrice(productUpdateDto.price());

        return new ProductDetailDto(product);
    }

    @Transactional
    public void deleteProduct(UUID idProduct) {
        Product product = productRespository.findById(idProduct)
                .orElseThrow(ProductNotFoundException::new);
        productRespository.delete(product);
    }
}
