package com.example.yanghyemin.dao;

import com.example.yanghyemin.entity.Ingredients;

import java.util.List;

public interface IngredientsDao {

    Ingredients insertIngredients(Ingredients ingredients);
    Ingredients updateCocktail(Long number, String name, Integer price, String url) throws Exception;
    void deleteIngredients(Long number) throws Exception;
    List<Ingredients> listAllIngredients();
    List<Ingredients> listIngredientsByName(String name);

}
