package com.example.yanghyemin.dao.impl;

import com.example.yanghyemin.dao.IngredientsDao;
import com.example.yanghyemin.entity.Ingredients;
import com.example.yanghyemin.repository.IngredientsRepository;
import com.example.yanghyemin.repository.QIngredientsRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.example.yanghyemin.entity.QIngredients.ingredients;

@Component
public class IngredientsDaoImpl implements IngredientsDao {
    private final IngredientsRepository ingredientsRepository;
    private final QIngredientsRepository qIngredientsRepository;

    @Autowired
    public IngredientsDaoImpl(IngredientsRepository ingredientsRepository, QIngredientsRepository qIngredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
        this.qIngredientsRepository = qIngredientsRepository;
    }

    @Override
    public Ingredients insertIngredients(Ingredients ingredients) {
        Ingredients saveIngredients = ingredientsRepository.save(ingredients);
        return saveIngredients;
    }

    @Override
    public Ingredients updateIngredients(Long number, String name, Integer price, String url) throws Exception{
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
        List<Ingredients> allIngredients = ingredientsRepository.findAll();
        return allIngredients;
    }

    @Override
    public List<Ingredients> listIngredientsByName(String name) {
        List<Ingredients> selectIngredients = ingredientsRepository.findByNameContaining(name);
        return selectIngredients;
    }

    @Override
    public Ingredients selectIngredients(Long number) {
        Predicate predicate = ingredients.number.eq(number);
        Optional<Ingredients> selectIngredients = qIngredientsRepository.findOne(predicate);
        return selectIngredients.isPresent() ? selectIngredients.get() : null;
    }

    @Override
    public Ingredients selectIngredientsName(String name) {
        Predicate predicate = ingredients.name.eq(name);
        Optional<Ingredients> selectIngredients = qIngredientsRepository.findOne(predicate);
        return selectIngredients.isPresent() ? selectIngredients.get() : null;
    }
}
