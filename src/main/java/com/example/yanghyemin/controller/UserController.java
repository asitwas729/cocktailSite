package com.example.yanghyemin.controller;

import com.example.yanghyemin.dto.UserResponseDto;
import com.example.yanghyemin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://3.39.190.51:3000")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserResponseDto>> allUserList(HttpServletRequest request) {
        List<UserResponseDto> userResponseDtoList = userService.listAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDtoList);
    }

    @GetMapping("/listOrderByName")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserResponseDto>> allUserOrderByName(HttpServletRequest request) {
        List<UserResponseDto> userResponseDtoList = userService.listAllByNameAsc();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDtoList);
    }

}
