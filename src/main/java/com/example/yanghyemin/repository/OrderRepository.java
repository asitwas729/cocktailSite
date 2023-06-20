package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //상품 id 별 주문 리스트
    List<Order> findByProductId(Long pId);

    //유저 id 별 주문 리스트
    List<Order> findByUserId(String uId);
}
