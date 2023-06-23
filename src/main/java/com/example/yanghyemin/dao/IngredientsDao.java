package com.example.yanghyemin.dao;

import com.example.yanghyemin.entity.Ingredients;

import java.util.List;

public interface IngredientsDao {
    //재료 등록
    Ingredients insertIngredients(Ingredients ingredients);
    //재료 수정
    Ingredients updateIngredients(Long number, String name, Integer price, String url) throws Exception;
    //재료 삭제
    void deleteIngredients(Long number) throws Exception;
    //전체 재료 리스트
    List<Ingredients> listAllIngredients();
    //이름 검색 재료 리스트
    List<Ingredients> listIngredientsByName(String name);
    //아이디를 통해 가져온 재료 정보
    Ingredients selectIngredients(Long number);
    Ingredients selectIngredientsName(String name);

}
