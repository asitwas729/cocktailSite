package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {

    //전체 칵테일재료 리스트
    List<Ingredients> findAll();
    //등록시 전체 칵테일재료 검색
    List<Ingredients> findByNameContaining(String name);
}
