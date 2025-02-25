package com.example.learnSpringBoot.JPACriteria.entity;

import com.example.learnSpringBoot.JPACriteria.dto.OrderDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity(name="Order_info")
@Data
@Table(name="order_details")
public class OrderDetail {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_info", referencedColumnName = "user_id")
    private UserDetail userDetail;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "orderDetails", orphanRemoval = true)
    private List<Product> productList;

    public OrderDto toDto() {
        return new OrderDto(this.id,this.userDetail.toDto(),this.productList);
    }
}
