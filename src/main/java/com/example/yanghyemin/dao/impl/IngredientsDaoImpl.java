package com.example.yanghyemin.dao.impl;

import com.example.yanghyemin.dao.IngredientsDao;
import com.example.yanghyemin.entity.Ingredients;
import com.example.yanghyemin.repository.IngredientsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IngredientsDaoImpl implements IngredientsDao {
    private final IngredientsRepository ingredientsRepository;

    public IngredientsDaoImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public Ingredients insertIngredients(Ingredients ingredients) {
        Ingredients saveIngredients = ingredientsRepository.save(ingredients);
        return saveIngredients;
    }

    @Override
    public Ingredients updateCocktail(Long number, String name, Integer price, String url) throws Exception{
        Optional<Ingredients> selectIngredients = ingredientsRepository.findById(number);
        Ingredients updateIngredients;

        if(selectIngredients.isPresent()){
            Ingredients ingredients = selectIngredients.get();
            ingredients.setName(name);
            ingredients.setPrice(price);
            ingredients.setUrl(url);

            updateIngredients = ingredientsRepository.save(ingredients);
        }else throw new Exception();
        return updateIngredients;
    }

    @Override
    public void deleteIngredients(Long number) throws Exception {
        Optional<Ingredients> deleteIngredients = ingredientsRepository.findById(number);

        if(deleteIngredients.isPresent()){
            Ingredients ingredients = deleteIngredients.get();
            ingredientsRepository.delete(ingredients);
        }else throw new Exception();
    }

    @Override
    public List<Ingredients> listAllIngredients() {
        List<Ingredients> ingredientsList = ingredientsRepository.findAll();
        return ingredientsList;
    }

    @Override
    public List<Ingredients> listIngredientsByName(String name) {
        List<Ingredients> ingredientsList = ingredientsRepository.findByNameContaining(name);
        return ingredientsList;
    }
}
