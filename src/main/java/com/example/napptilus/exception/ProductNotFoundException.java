package com.example.napptilus.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String productId){
        super(String.format("Product not found for that specific date range: %s", productId));
    }
}
