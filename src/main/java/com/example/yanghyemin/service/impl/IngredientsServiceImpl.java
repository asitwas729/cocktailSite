package com.example.yanghyemin.service.impl;

import com.example.yanghyemin.dao.IngredientsDao;
import com.example.yanghyemin.dto.CocktailResponseDto;
import com.example.yanghyemin.dto.IngredientsDto;
import com.example.yanghyemin.dto.IngredientsResponseDto;
import com.example.yanghyemin.entity.Cocktail;
import com.example.yanghyemin.entity.Ingredients;
import com.example.yanghyemin.service.IngredientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {
    private final IngredientsDao ingredientsDao;


    @Override
    public IngredientsResponseDto saveIngredients(IngredientsDto ingredientsDto) {
        Ingredients ingredients = new Ingredients();
        ingredients.setName(ingredients.getName());
        ingredients.setPrice(ingredients.getPrice());
        ingredients.setUrl(ingredients.getUrl());

        Ingredients saveIngredients = ingredientsDao.insertIngredients(ingredients);
        IngredientsResponseDto ingredientsResponseDto = new IngredientsResponseDto();
        ingredientsResponseDto.setName(saveIngredients.getName());
        ingredientsResponseDto.setPrice(saveIngredients.getPrice());
        ingredientsResponseDto.setUrl(saveIngredients.getUrl());
        return ingredientsResponseDto;
    }

    @Override
    public IngredientsResponseDto changeIngredients(Long number, String name, Integer price, String url) throws Exception {
        Ingredients changeIngredients = ingredientsDao.updateCocktail(number, name, price, url);

        IngredientsResponseDto ingredientsResponseDto = new IngredientsResponseDto();
        ingredientsResponseDto.setNumber(changeIngredients.getNumber());
        ingredientsResponseDto.setName(changeIngredients.getName());
        ingredientsResponseDto.setPrice(changeIngredients.getPrice());
        ingredientsResponseDto.setUrl(changeIngredients.getUrl());
        return ingredientsResponseDto;
    }

    @Override
    public void deleteIngredients(Long number) throws Exception {
        ingredientsDao.deleteIngredients(number);
    }

    @Override
    public List<IngredientsResponseDto> getIngredientsByName(String name) {
        List<Ingredients> ingredients = ingredientsDao.listIngredientsByName(name);
        List<IngredientsResponseDto> selectIngredients = ingredients
                .stream()
                .map(IngredientsResponseDto::new)
                .collect(Collectors.toList());
        return selectIngredients;
    }

    @Override
    public List<IngredientsResponseDto> listAllIngredients() {
        List<Ingredients> ingredients = ingredientsDao.listAllIngredients();
        List<IngredientsResponseDto> selectIngredients = ingredients
                .stream()
                .map(IngredientsResponseDto::new)
                .collect(Collectors.toList());
        return selectIngredients;
    }
}
