package com.example.learnSpringBoot.JPACriteria.repository;

import com.example.learnSpringBoot.JPACriteria.dto.OrderDto;
import com.example.learnSpringBoot.JPACriteria.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetail,Integer> {
    @Query("Select o from Order_info o join userDetail u where u.id=?1")
    List<OrderDetail> findByUser(int userId);
}
