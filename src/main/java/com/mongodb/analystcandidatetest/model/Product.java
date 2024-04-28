package com.mongodb.analystcandidatetest.model;

import com.mongodb.analystcandidatetest.dto.product.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private UUID id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private Category category;

    public Product(ProductRequestDto productRequestDto) {
        this.title = productRequestDto.title();
        this.description = productRequestDto.description();
        this.ownerId = productRequestDto.ownerId();
        this.price = productRequestDto.price();
    }
}
