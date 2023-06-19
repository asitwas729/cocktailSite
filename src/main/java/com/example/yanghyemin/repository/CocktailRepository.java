package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
  //전체 편의점칵테일 리스트
  List<Cocktail> findAll();

  //생성일 내림차순(최신순) 정렬 편의점칵테일 리스트
  List<Cocktail> findAllByOrderByCreatedAtDesc();

  //상품명 통해 가져온 편의점칵테일 리스트
  List<Cocktail> findByNameContaining(String name);
  //재료 통해 가져온 편의점칵테일 리스트
  List<Cocktail> findByIngredientsContaining(String ingredients);
  //재료 통해 가져온 편의점칵테일 리스트
  List<Cocktail> findByAlcohol(Float alcohol);
  //검색창(이름,재료) 편의점칵테일 리스트
  List<Cocktail> findByNameContainingOrIngredientsContaining(String search1, String search2);

}
