package com.example.yanghyemin.dao.impl;

import com.example.yanghyemin.dao.MBTIDao;
import com.example.yanghyemin.entity.Cocktail;
import com.example.yanghyemin.entity.MBTI;
import com.example.yanghyemin.repository.MBTIRepository;
import com.example.yanghyemin.repository.QMBTIRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MBTIDaoImpl implements MBTIDao {
  private final MBTIRepository mbtiRepository;

  public MBTIDaoImpl(MBTIRepository mbtiRepository) {
    this.mbtiRepository = mbtiRepository;
  }

  @Override
  public List<MBTI> listAllMBTI() {
    List<MBTI> mbtiList = mbtiRepository.findAll();
    return mbtiList;
  }
}
