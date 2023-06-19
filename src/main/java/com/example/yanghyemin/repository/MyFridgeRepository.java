package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.MyFridge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyFridgeRepository extends JpaRepository<MyFridge, Long> {
  //user별 My냉장고 등록 리스트
  List<MyFridge> findByUserId(String userId);


}
