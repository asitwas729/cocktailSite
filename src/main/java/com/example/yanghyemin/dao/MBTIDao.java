package com.example.yanghyemin.dao;

import com.example.yanghyemin.entity.Cocktail;
import com.example.yanghyemin.entity.MBTI;

import java.util.List;

public interface MBTIDao {
  //전체 편의점칵테일 리스트
  List<MBTI> listAllMBTI();

}
