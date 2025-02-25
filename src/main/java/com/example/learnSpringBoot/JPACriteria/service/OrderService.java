package com.example.learnSpringBoot.JPACriteria.service;


import com.example.learnSpringBoot.JPACriteria.dto.OrderDto;
import com.example.learnSpringBoot.JPACriteria.entity.OrderDetail;
import com.example.learnSpringBoot.JPACriteria.payload.OrderPayload;

import java.util.List;

 public interface OrderService {

     OrderDto createOrder(OrderPayload orderPayload);
     OrderDto getOrderDetail(int orderId);
     List<OrderDto> getAllOrdersByUser(int userId);
     OrderDto updateOrder(int id, OrderPayload orderPayload);
     String deleteOrder(int id);
}
