package com.example.yanghyemin.dao;

import com.example.yanghyemin.entity.MyFridge;

import java.util.List;

public interface MyFridgeDao {
  //My냉장고 등록
  MyFridge insertMyFridge(MyFridge myFridge);

  //My냉장고 삭제
  void deleteMyFridge(Long id) throws Exception;

  //user id list
  List<MyFridge> listAllOrgerByUserId(String userId);
}
