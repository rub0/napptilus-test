package com.example.napptilus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Entity
@Table(name = "prices")
public class Product {
    @Column(name = "product_id")
    private String productId;
    @Column(name = "brand_id")
    private String brandId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "price_list")
    @Id
    private String priceId;
    @Column(name = "priority")
    private int priority;
    @Column(name = "price")
    private String price;
    @Column(name = "curr")
    private String currency;
}
