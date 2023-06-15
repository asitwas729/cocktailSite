package com.example.yanghyemin.service;

import com.example.yanghyemin.dto.CocktailDto;
import com.example.yanghyemin.dto.CocktailResponseDto;
import com.example.yanghyemin.entity.Cocktail;

import java.util.List;

public interface CocktailService {
  //번호를 통해 편의점칵테일 리스트
  CocktailResponseDto getCocktail(Long number);

  //이름을 통해 가져온 편의점칵테일 리스트
  List<CocktailResponseDto> getCocktailByName(String name);
  
  //재료를 통해 가져온 편의점칵테일 리스트
  List<CocktailResponseDto> getCocktailByIngredients(String ingredients);

  //도수 통해 가져온 편의점칵테일 리스트
  List<CocktailResponseDto> getCocktailByAlcohol(Float alcohol);

  //검색창(이름,재료) 편의점칵테일 리스트
  List<CocktailResponseDto> getCocktailByNameContainingAndIngredientsContaining(String search);

  //전체 편의점칵테일 리스트
  List<CocktailResponseDto> listAllCocktail();

  //생성일 내림차순(최신순) 정렬 편의점칵테일 리스트
  List<CocktailResponseDto> listAllByCreatedAtDesc();
  

  //CRUD
  //편의점칵테일 등록
  CocktailResponseDto saveCocktail(CocktailDto cocktailDto);
  //편의점칵테일 수정
  CocktailResponseDto changeCocktail(Long number, String name, String ingredients, String instruction, Float alcohol, Float sweet) throws Exception;
  //편의점칵테일 삭제
  void delectCocktail(Long number) throws  Exception;
}
