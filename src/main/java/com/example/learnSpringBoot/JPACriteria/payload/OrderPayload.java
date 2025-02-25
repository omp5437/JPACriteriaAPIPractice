package com.example.learnSpringBoot.JPACriteria.payload;

import com.example.learnSpringBoot.JPACriteria.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderPayload {
    private int userId;
    private List<Product> products;

    public OrderPayload(int userId,List<Product> productList){
        this.userId=userId;
        this.products=productList;
    }
}
