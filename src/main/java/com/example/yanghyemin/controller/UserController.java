package com.example.yanghyemin.controller;

import com.example.yanghyemin.dto.UserResponseDto;
import com.example.yanghyemin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
