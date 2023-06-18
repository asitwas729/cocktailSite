package com.example.yanghyemin.service;

import com.example.yanghyemin.dto.IngredientsResponseDto;
import com.example.yanghyemin.dto.IngredientsDto;

import java.util.List;

public interface IngredientsService {
    //CRUD
    IngredientsResponseDto saveIngredients(IngredientsDto ingredientsDto);
    IngredientsResponseDto changeIngredients(Long number, String name, Integer price, String url) throws Exception;
    void deleteIngredients(Long number) throws Exception;

    //List
    List<IngredientsResponseDto> getIngredientsByName(String name);
    List<IngredientsResponseDto> listAllIngredients();
}
