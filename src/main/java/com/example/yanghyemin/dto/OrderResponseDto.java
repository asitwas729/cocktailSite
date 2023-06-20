package com.example.yanghyemin.dto;

import com.example.yanghyemin.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;
    private Long productId;
    private String productName;
    private String userId;
    private String userName;
    private int price;
    private String url;

    public OrderResponseDto(Order order) {
        id = order.getId();
        productId = order.getProductId();
        productName = order.getProductName();
        userId = order.getUserId();
        userName = order.getUserName();
        price = order.getPrice();
        url = order.getUrl();
    }
}
