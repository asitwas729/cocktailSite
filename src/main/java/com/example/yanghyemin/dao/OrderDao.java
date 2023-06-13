package com.example.yanghyemin.dao;

import com.example.yanghyemin.entity.Order;

import java.util.List;

public interface OrderDao {
    //주문 등록
    Order insertOrder(Order order);

    //주문 id를 통한 주문 정보 조회
    Order selectOrder(Long id);

    //전체 리스트
    List<Order> listAllOrder();

    //product id 리스트
    List<Order> listAllOrderByProductId(Long pId);

    //user id list
    List<Order> listAllOrderByUserId(String uId);
}
