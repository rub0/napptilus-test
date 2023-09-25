package com.example.napptilus.services;

import com.example.napptilus.exception.ProductNotFoundException;
import com.example.napptilus.model.Product;
import com.example.napptilus.repositories.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;
import static java.util.Optional.ofNullable;

@Service
public class ProductService {

    @Autowired
    PricesRepository pricesRepository;
    public Product getProductBy(String brandId, String productId, Date applicationDate) {
        List<Product> results = pricesRepository.findByBrandIdAndProductId(brandId, productId);
        return ofNullable(results.stream()
                .filter(product -> {
                    if ((applicationDate.after(product.getStartDate()) && applicationDate.before(product.getEndDate()))
                    || applicationDate.equals(product.getStartDate())
                    || applicationDate.equals(product.getEndDate()))
                        return true;
                    return false;
                })
                .reduce(null, (result, current) -> {
                    if (result == null)
                        return current;
                    if(result.getPriority() < current.getPriority())
                        return current;
                    return result;
                })).orElseThrow(() -> new ProductNotFoundException(productId));
    }
}
