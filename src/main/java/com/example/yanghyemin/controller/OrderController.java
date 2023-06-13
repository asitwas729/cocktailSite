package com.example.yanghyemin.controller;

import com.example.yanghyemin.dto.OrderDto;
import com.example.yanghyemin.dto.OrderResponseDto;
import com.example.yanghyemin.dto.ProductResponseDto;
import com.example.yanghyemin.dto.UserResponseDto;
import com.example.yanghyemin.security.JwtTokenProvider;
import com.example.yanghyemin.service.OrderService;
import com.example.yanghyemin.service.ProductService;
import com.example.yanghyemin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final ProductService productService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping()
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<OrderResponseDto> insertOrder(HttpServletRequest request, @RequestParam Long productId, @RequestParam String productName) throws Exception {
        String userId = jwtTokenProvider.getUsername(request.getHeader("X-AUTH-TOKEN"));
        UserResponseDto userResponseDto = userService.userById(userId);
        ProductResponseDto productResponseDto = productService.getProduct(productId);

        System.out.println("[OrderController] userId" + userId);

        if(productResponseDto.getStock() > 0) {
            OrderDto orderDto = new OrderDto();
            orderDto.setProductId(productId);
            orderDto.setProductName(productName);
            orderDto.setUserId(userResponseDto.getUId());
            orderDto.setUserName(userResponseDto.getName());
            orderDto.setPrice(productResponseDto.getPrice());

            OrderResponseDto orderResponseDto = orderService.insertOrder(orderDto);
            productService.changeProductStock(productResponseDto.getNumber(), productResponseDto.getStock());
            return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
        } else return null;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderResponseDto>> listAllOrder() {
        List<OrderResponseDto> orderResponseDtoList = orderService.listAllOrder();
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDtoList);
    }

    @GetMapping("/listByProductId")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderResponseDto>> listByProductId(@RequestParam Long pId) {
        List<OrderResponseDto> orderResponseDtoList = orderService.listOrderByProductId(pId);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDtoList);
    }

    @GetMapping("/listByUserId")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderResponseDto>> listByUserId(@RequestParam String uId) {
        List<OrderResponseDto> orderResponseDtoList = orderService.listOrderByUserId(uId);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDtoList);
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<OrderResponseDto> orderById(@RequestParam Long id) {
        OrderResponseDto orderResponseDto = orderService.selectOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }



}
