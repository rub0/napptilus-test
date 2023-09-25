package com.example.napptilus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ProductDTO {
    private String productId;
    private String brandId;
    private Date startDate;
    private Date endDate;
    private String price;
    private String currency;
}
