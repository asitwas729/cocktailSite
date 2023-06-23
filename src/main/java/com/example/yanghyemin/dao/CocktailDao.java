package com.example.yanghyemin.dao;

import com.example.yanghyemin.dto.CocktailResponseDto;
import com.example.yanghyemin.entity.Cocktail;

import java.sql.SQLException;
import java.util.List;

public interface CocktailDao {
  //편의점칵테일 등록
  Cocktail insertCocktail(Cocktail cocktail);

  //편의점칵테일 수정
  Cocktail updateCocktail(Long number, String name, String ingredients, String instruction, String Url, Float alcohol, Float sweet) throws Exception;

  //편의점칵테일 삭제
  void deleteCocktail(Long number) throws Exception;

  //전체 편의점칵테일 리스트
  List<Cocktail> listAllCocktail();

  //생성일 내림차순 정렬 편의점칵테일 리스트
  List<Cocktail> listCocktailByCreatedAt();
//검색 기능
  //이름 통해 가져온 편의점칵테일 리스트
  List<Cocktail> listCocktailByName(String name);
  //재료 통해 가져온 편의점칵테일 리스트
  List<Cocktail> listCocktailByIngredients(String ingredients);
  //검색창(이름,재료) 편의점칵테일 리스트
  List<Cocktail> listCocktailByNameContainingAndIngredientsContaining(String search);
  List<Cocktail> listCocktailByIngredientsContainingOr(String s1, String s2, String s3);
  
  //도수 통해 가져온 편의점칵테일 리스트
  List<Cocktail> listCocktailByAlcohol(Float alcohol);



  //아이디를 통해 가져온 상품 정보
  Cocktail selectCocktail(Long number);
  //이름 넣으면 재료 출력함
  Cocktail selectIngredients(String name);
  Cocktail selectCocktailName(String name);
}
