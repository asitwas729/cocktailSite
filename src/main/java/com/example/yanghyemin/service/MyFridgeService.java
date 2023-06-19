package com.example.yanghyemin.service;

import com.example.yanghyemin.dto.MyFridgeDto;
import com.example.yanghyemin.dto.MyFridgeResponseDto;

import java.util.List;

public interface MyFridgeService {
  //My냉장고 재료 등록
  MyFridgeResponseDto insertMyFridge(MyFridgeDto myFridgeDto);

  //My냉장고 재료 삭제
  void deleteMyFridge(Long id) throws Exception;

  //UserId list
  List<MyFridgeResponseDto> listOrderByUserId(String userId);
}
