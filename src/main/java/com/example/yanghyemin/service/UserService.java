package com.example.haren201930326.service;

import com.example.haren201930326.dto.ProductResponseDto;
import com.example.haren201930326.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto userById(String uId);

    //전체 유저 리스트
    List<UserResponseDto> listAllUser();

    //가격순 내림차순 정렬 상품 리스트
    List<UserResponseDto> listAllByNameAsc();
}
