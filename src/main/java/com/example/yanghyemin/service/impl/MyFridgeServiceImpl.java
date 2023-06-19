package com.example.yanghyemin.service.impl;

import com.example.yanghyemin.dao.MyFridgeDao;
import com.example.yanghyemin.dto.MyFridgeDto;
import com.example.yanghyemin.dto.MyFridgeResponseDto;
import com.example.yanghyemin.entity.MyFridge;
import com.example.yanghyemin.service.MyFridgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyFridgeServiceImpl implements MyFridgeService {
  private final MyFridgeDao myFridgeDao;

  @Override
  public MyFridgeResponseDto insertMyFridge(MyFridgeDto myFridgeDto) {
    MyFridge myFridge = new MyFridge();
    myFridge.setIngredientsId(myFridgeDto.getIngredientsId());
    myFridge.setIngredientsName(myFridgeDto.getIngredientsName());
    myFridge.setIngredientsUrl(myFridge.getIngredientsUrl());
    myFridge.setUserId(myFridgeDto.getUserId());
    myFridge.setUserName(myFridgeDto.getUserName());
    myFridge.setCreatedAt(LocalDateTime.now());
    myFridge.setUpdatedAt(LocalDateTime.now());

    MyFridge saveMyFridge = myFridgeDao.insertMyFridge(myFridge);

    MyFridgeResponseDto myFridgeResponseDto = new MyFridgeResponseDto();
    myFridgeResponseDto.setId(saveMyFridge.getId());
    myFridgeResponseDto.setIngredientsId(saveMyFridge.getIngredientsId());
    myFridgeResponseDto.setIngredientsName(saveMyFridge.getIngredientsName());
    myFridgeResponseDto.setIngredientsUrl(saveMyFridge.getIngredientsUrl());
    myFridgeResponseDto.setUserId(saveMyFridge.getUserId());
    myFridgeResponseDto.setUserName(saveMyFridge.getUserName());

    return myFridgeResponseDto;
  }

  @Override
  public void deleteMyFridge(Long id) throws Exception {
    myFridgeDao.deleteMyFridge(id);
  }

  @Override
  public List<MyFridgeResponseDto> listOrderByUserId(String userId) {
    List<MyFridge> myFridgeList = myFridgeDao.listAllOrgerByUserId(userId);
    List<MyFridgeResponseDto> selectMyFridge = myFridgeList
        .stream()
        .map(MyFridgeResponseDto::new)
        .collect(Collectors.toList());
    return selectMyFridge;
  }
}
