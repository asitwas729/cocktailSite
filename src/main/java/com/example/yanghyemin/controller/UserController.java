package com.example.haren201930326.controller;

import com.example.haren201930326.dto.OrderDto;
import com.example.haren201930326.dto.OrderResponseDto;
import com.example.haren201930326.dto.UserResponseDto;
import com.example.haren201930326.entity.Order;
import com.example.haren201930326.entity.User;
import com.example.haren201930326.service.OrderService;
import com.example.haren201930326.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserResponseDto>> allUserList() {
        List<UserResponseDto> userResponseDtoList = userService.listAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDtoList);
    }

    @GetMapping("/listOrderByName")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserResponseDto>> allUserOrderByName() {
        List<UserResponseDto> userResponseDtoList = userService.listAllByNameAsc();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDtoList);
    }

}
