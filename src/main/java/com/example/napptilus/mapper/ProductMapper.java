package com.example.napptilus.mapper;

import com.example.napptilus.model.Product;
import com.example.napptilus.model.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO map(Product product) {
        return ProductDTO.builder()
                .productId(product.getProductId())
                .price(product.getPrice())
                .startDate(product.getStartDate())
                .endDate(product.getEndDate())
                .currency(product.getCurrency())
                .brandId(product.getBrandId())
                .build();
    }
}
