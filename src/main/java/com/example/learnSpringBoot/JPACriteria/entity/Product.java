package com.example.learnSpringBoot.JPACriteria.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;
    private int quantity;
    private int price;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="order_info", referencedColumnName="order_id")
    private OrderDetail orderDetails;


}
