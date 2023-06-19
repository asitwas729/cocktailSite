package com.example.yanghyemin.service;

import com.example.yanghyemin.dto.IngredientsResponseDto;
import com.example.yanghyemin.dto.IngredientsDto;

import java.util.List;

public interface IngredientsService {
    //재료 번호를 통해 재료 정보를 가지고 온다.
    IngredientsResponseDto getIngredients(Long number);
    //CRUD
    IngredientsResponseDto saveIngredients(IngredientsDto ingredientsDto);
    IngredientsResponseDto changeIngredients(Long number, String name, Integer price, String url) throws Exception;
    void deleteIngredients(Long number) throws Exception;

    //List
    List<IngredientsResponseDto> getIngredientsByName(String name);
    List<IngredientsResponseDto> listAllIngredients();
}
