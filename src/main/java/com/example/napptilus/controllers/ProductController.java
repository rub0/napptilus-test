package com.example.napptilus.controllers;

import com.example.napptilus.mapper.ProductMapper;
import com.example.napptilus.model.ProductDTO;
import com.example.napptilus.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/brands")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductMapper mapper;

    @GetMapping("{brandId}/products/{productId}")
    public ResponseEntity<ProductDTO> getProduct(
            @PathVariable(value = "brandId") final String brandId,
            @PathVariable(value = "productId") final String productId,
            @RequestParam("applicationDate") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
            final Date applicationDate
    ) {
        return ResponseEntity.ok(mapper.map(productService.getProductBy(brandId, productId, applicationDate)));
    }
}
