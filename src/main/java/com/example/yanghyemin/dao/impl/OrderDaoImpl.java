package com.example.yanghyemin.dao.impl;

import com.example.yanghyemin.dao.OrderDao;
import com.example.yanghyemin.entity.Cocktail;
import com.example.yanghyemin.entity.Order;
import com.example.yanghyemin.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {
    private final OrderRepository orderRepository;

    @Override
    public Order insertOrder(Order order) {
        Order saveOrder = orderRepository.save(order);
        return saveOrder;
    }


    @Override
    public void deleteOrder(Long id) throws Exception {
        Optional<Order> selectedOrder = orderRepository.findById(id);

        if(selectedOrder.isPresent()) {
            Order order = selectedOrder.get();
            orderRepository.delete(order);
        } else throw new Exception();
    }

    @Override
    public Order selectOrder(Long id) {
        Order selectOrder = orderRepository.getReferenceById(id);
        return selectOrder;
    }

    @Override
    public List<Order> listAllOrder() {
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }

    @Override
    public List<Order> listAllOrderByProductId(Long pId) {
        List<Order> orderList = orderRepository.findByProductId(pId);
        return orderList;
    }

    @Override
    public List<Order> listAllOrderByUserId(String uId) {
        List<Order> orderList = orderRepository.findByUserId(uId);
        return orderList;
    }
}
