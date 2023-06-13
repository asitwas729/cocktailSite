package com.example.haren201930326.service;

import com.example.haren201930326.dto.OrderDto;
import com.example.haren201930326.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    //등록할 주문
    OrderResponseDto insertOrder(OrderDto orderDto);

    //전체 주문 리스트
    List<OrderResponseDto> listAllOrder();

    //상품 아이디별 주문 리스트
    List<OrderResponseDto> listOrderByProductId(Long pId);

    //user id list
    List<OrderResponseDto> listOrderByUserId(String uId);

    //order id
    OrderResponseDto selectOrder(Long id);

}
