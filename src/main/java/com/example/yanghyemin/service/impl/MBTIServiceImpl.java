package com.example.yanghyemin.service.impl;

import com.example.yanghyemin.dao.MBTIDao;
import com.example.yanghyemin.dto.CocktailResponseDto;
import com.example.yanghyemin.dto.MBTIResponseDto;
import com.example.yanghyemin.entity.Cocktail;
import com.example.yanghyemin.entity.MBTI;
import com.example.yanghyemin.service.MBTIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MBTIServiceImpl implements MBTIService {
  private final MBTIDao mbtiDao;

  @Override
  public List<MBTIResponseDto> listAllMBTI() {
    List<MBTI> mbti = mbtiDao.listAllMBTI();
    List<MBTIResponseDto> selectMBTI = mbti
        .stream()
        .map(MBTIResponseDto::new)
        .collect(Collectors.toList());
    return selectMBTI;
  }
}
