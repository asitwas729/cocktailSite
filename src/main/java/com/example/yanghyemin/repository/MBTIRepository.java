package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.MBTI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MBTIRepository extends JpaRepository<MBTI, Long>{
  //전체 편의점칵테일 리스트
  List<MBTI> findAll();
}
