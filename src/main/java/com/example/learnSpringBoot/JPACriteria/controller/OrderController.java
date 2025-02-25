package com.example.learnSpringBoot.JPACriteria.controller;

import com.example.learnSpringBoot.JPACriteria.dto.OrderDto;
import com.example.learnSpringBoot.JPACriteria.payload.OrderPayload;
import com.example.learnSpringBoot.JPACriteria.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

     @Autowired
     private OrderService orderService;

     @PostMapping("/create")
     public ResponseEntity<OrderDto> createOrder(@RequestBody OrderPayload orderPayload){
           System.out.println(orderPayload);
           OrderDto orderDto=orderService.createOrder(orderPayload);
           return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
     }

     @GetMapping("/get-order-detail/{id}")
     public ResponseEntity<OrderDto> getOrderDetail(@PathVariable("id") int orderId){
         OrderDto orderDto=orderService.getOrderDetail(orderId);
         return new ResponseEntity<>(orderDto, HttpStatus.OK);
     }

    @GetMapping("/get-order-by-user/{userId}")
    public ResponseEntity<List<OrderDto>> getAllOrders(@PathVariable("userId") int userId){
        List<OrderDto> orderDto=orderService.getAllOrdersByUser(userId);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<String> deleteOrderDetails(@PathVariable("id") int orderId){
        return new ResponseEntity<>(orderService.deleteOrder(orderId), HttpStatus.OK);
    }

}
