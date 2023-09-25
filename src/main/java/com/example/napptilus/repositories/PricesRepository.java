package com.example.napptilus.repositories;

import com.example.napptilus.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PricesRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM PRICES u WHERE u.brand_id = :brandId and u.product_id = :productId",
            nativeQuery = true)
    List<Product> findByBrandIdAndProductId(String brandId, String productId);
}