package com.example.learnSpringBoot.JPACriteria.dto;
import com.example.learnSpringBoot.JPACriteria.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private int id;
    private UserDto userDetail;
    private List<Product> productList;

    public OrderDto(int id, UserDto dto, List<Product> productList) {
        this.id=id;
        this.userDetail=dto;
        this.productList=productList;
    }
}
