package com.example.yanghyemin.service.impl;

import com.example.yanghyemin.dao.OrderDao;
import com.example.yanghyemin.dto.OrderDto;
import com.example.yanghyemin.dto.OrderResponseDto;
import com.example.yanghyemin.entity.Order;
import com.example.yanghyemin.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;

    @Override
    public OrderResponseDto insertOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setProductId(orderDto.getProductId());
        order.setProductName(orderDto.getProductName());
        order.setUserId(orderDto.getUserId());
        order.setUserName(orderDto.getUserName());
        order.setPrice(orderDto.getPrice());
        order.setUrl(orderDto.getUrl());
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        Order saveOrder = orderDao.insertOrder(order);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(saveOrder.getId());
        orderResponseDto.setProductId(saveOrder.getProductId());
        orderResponseDto.setProductName(saveOrder.getProductName());
        orderResponseDto.setUserId(saveOrder.getUserId());
        orderResponseDto.setUserName(saveOrder.getUserName());
        orderResponseDto.setPrice(saveOrder.getPrice());
        orderResponseDto.setUrl(saveOrder.getUrl());

        return orderResponseDto;
    }



    @Override
    public void delectOrder(Long id) throws Exception {
        orderDao.deleteOrder(id);
    }

    @Override
    public List<OrderResponseDto> listAllOrder() {
        List<Order> orderList = orderDao.listAllOrder();
        List<OrderResponseDto> orderResponseDtoList = orderList
                .stream()
                .map(OrderResponseDto::new)
                .collect(Collectors.toList());
        return orderResponseDtoList;
    }

    @Override
    public List<OrderResponseDto> listOrderByProductId(Long pId) {
        List<Order> orderList = orderDao.listAllOrderByProductId(pId);
        List<OrderResponseDto> orderResponseDtoList = orderList
                .stream()
                .map(OrderResponseDto::new)
                .collect(Collectors.toList());
        return orderResponseDtoList;
    }

    @Override
    public List<OrderResponseDto> listOrderByUserId(String uId) {
        List<Order> orderList = orderDao.listAllOrderByUserId(uId);
        List<OrderResponseDto> orderResponseDtoList = orderList
                .stream()
                .map(OrderResponseDto::new)
                .collect(Collectors.toList());
        return orderResponseDtoList;
    }

    @Override
    public OrderResponseDto selectOrder(Long id) {
        Order order = orderDao.selectOrder(id);
        OrderResponseDto orderResponseDto = new OrderResponseDto(order);
        return orderResponseDto;
    }
}
