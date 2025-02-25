package com.example.learnSpringBoot.JPACriteria.repository;

import com.example.learnSpringBoot.JPACriteria.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetail,Integer> {
}
