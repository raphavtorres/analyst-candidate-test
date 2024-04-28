package com.mongodb.analystcandidatetest.controller;

import com.mongodb.analystcandidatetest.dto.product.ProductDetailDto;
import com.mongodb.analystcandidatetest.dto.product.ProductRequestDto;
import com.mongodb.analystcandidatetest.dto.product.ProductUpdateDto;
import com.mongodb.analystcandidatetest.model.Product;
import com.mongodb.analystcandidatetest.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDetailDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        ProductDetailDto productDetail = productService.createProduct(productRequestDto);
        return ResponseEntity.ok().body(productDetail);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> categories = productService.getAllProducts();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<ProductDetailDto> updateProduct(@PathVariable UUID idProduct, @RequestBody ProductUpdateDto productUpdateDto) {
        ProductDetailDto productDetailDto = productService.updateProduct(idProduct, productUpdateDto);
        return ResponseEntity.ok().body(productDetailDto);
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity deleteProduct(@PathVariable UUID idProduct) {
        productService.deleteProduct(idProduct);
        return ResponseEntity.noContent().build();
    }
}
