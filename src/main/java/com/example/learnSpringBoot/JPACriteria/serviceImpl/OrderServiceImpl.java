package com.example.learnSpringBoot.JPACriteria.serviceImpl;


import com.example.learnSpringBoot.JPACriteria.dto.OrderDto;
import com.example.learnSpringBoot.JPACriteria.entity.OrderDetail;

import com.example.learnSpringBoot.JPACriteria.entity.Product;
import com.example.learnSpringBoot.JPACriteria.entity.UserDetail;
import com.example.learnSpringBoot.JPACriteria.exceptions.ResourceNotFoundException;
import com.example.learnSpringBoot.JPACriteria.payload.OrderPayload;
import com.example.learnSpringBoot.JPACriteria.repository.OrderRepository;

import com.example.learnSpringBoot.JPACriteria.repository.UserRepository;
import com.example.learnSpringBoot.JPACriteria.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private UserRepository userRepo;


    @Override
    public OrderDto createOrder(OrderPayload orderPayload) {
        int userId=orderPayload.getUserId();
        UserDetail user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","userId",String.valueOf(userId)));
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setUserDetail(user);
        orderDetail.setProductList(orderPayload.getProducts());
        for(Product product:orderDetail.getProductList()){
            product.setOrderDetails(orderDetail);
        }
        return orderRepo.save(orderDetail).toDto();
    }

    @Override
    public OrderDto getOrderDetail(int orderId) {
        return orderRepo.findById(orderId).get().toDto();
    }

    @Override
    public List<OrderDto> getAllOrdersByUser(int userId) {
        UserDetail user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",String.valueOf(userId)));
        return orderRepo.findByUser(userId).stream().map(OrderDetail::toDto).collect(Collectors.toList());
    }

    @Override
   public OrderDto updateOrder(int id, OrderPayload orderPayload) {
//        OrderDetail order=orderRepo.findById(id).
//                                 orElseThrow(()-> new ResourceNotFoundException("Order","orderId",String.valueOf(id)));
//
        return null;
    }

    @Override
    public String deleteOrder(int id) {
        OrderDetail orderDetail=orderRepo.findById(id)
                               .orElseThrow(()->new ResourceNotFoundException("Order","orderId",String.valueOf(id)));

        orderRepo.deleteById(id);
        return "Order deleted successfully!";
    }
}
