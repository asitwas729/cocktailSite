package com.example.yanghyemin.service;

import com.example.yanghyemin.dto.CocktailResponseDto;
import com.example.yanghyemin.dto.MBTIResponseDto;

import java.util.List;

public interface MBTIService {
  //전체 리스트
  List<MBTIResponseDto> listAllMBTI();
}
