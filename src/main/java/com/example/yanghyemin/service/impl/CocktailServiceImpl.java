package com.example.yanghyemin.service.impl;

import com.example.yanghyemin.dao.CocktailDao;
import com.example.yanghyemin.dto.CocktailDto;
import com.example.yanghyemin.dto.CocktailResponseDto;
import com.example.yanghyemin.entity.Cocktail;
import com.example.yanghyemin.service.CocktailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CocktailServiceImpl implements CocktailService {
  private final CocktailDao cocktailDao;

  @Override
  public CocktailResponseDto getCocktail(Long number) {
    Cocktail cocktail = cocktailDao.selectCocktail(number);
    CocktailResponseDto cocktailResponseDto = new CocktailResponseDto();
    cocktailResponseDto.setName(cocktail.getName());
    cocktailResponseDto.setIngredients(cocktail.getIngredients());
    cocktailResponseDto.setInstruction(cocktail.getInstruction());
    cocktailResponseDto.setAlcohol(cocktail.getAlcohol());
    cocktailResponseDto.setSweet(cocktail.getSweet());
    return cocktailResponseDto;
  }

  @Override
  public List<CocktailResponseDto> getCocktailByName(String name) {
    List<Cocktail> cocktail = cocktailDao.listCocktailByName(name);
    List<CocktailResponseDto> selectCocktail = cocktail
        .stream()
        .map(CocktailResponseDto::new)
        .collect(Collectors.toList());
    return selectCocktail;
  }

  @Override
  public List<CocktailResponseDto> getCocktailByIngredients(String ingredients) {
    List<Cocktail> cocktail = cocktailDao.listCocktailByIngredients(ingredients);
    List<CocktailResponseDto> selectCocktail = cocktail
        .stream()
        .map(CocktailResponseDto::new)
        .collect(Collectors.toList());
    return selectCocktail;
  }

  @Override
  public List<CocktailResponseDto> getCocktailByAlcohol(Float alcohol) {
    List<Cocktail> cocktail = cocktailDao.listCocktailByAlcohol(alcohol);
    List<CocktailResponseDto> selectCocktail = cocktail
        .stream()
        .map(CocktailResponseDto::new)
        .collect(Collectors.toList());
    return selectCocktail;
  }

  @Override
  public List<CocktailResponseDto> listAllCocktail() {
    List<Cocktail> cocktail = cocktailDao.listAllCocktail();
    List<CocktailResponseDto> selectCocktail = cocktail
        .stream()
        .map(CocktailResponseDto::new)
        .collect(Collectors.toList());
    return selectCocktail;
  }

  @Override
  public List<CocktailResponseDto> listAllByCreatedAtDesc() {
    List<Cocktail> cocktail = cocktailDao.listCocktailByCreatedAt();
    List<CocktailResponseDto> selectCocktail = cocktail
        .stream()
        .map(CocktailResponseDto::new)
        .collect(Collectors.toList());
    return selectCocktail;
  }

  @Override
  public CocktailResponseDto saveCocktail(CocktailDto cocktailDto) {
    Cocktail cocktail = new Cocktail();
    cocktail.setName(cocktailDto.getName());
    cocktail.setIngredients(cocktailDto.getIngredients());
    cocktail.setInstruction(cocktailDto.getInstruction());
    cocktail.setAlcohol(cocktailDto.getAlcohol());
    cocktail.setSweet(cocktailDto.getSweet());
    cocktail.setCreatedAt(LocalDateTime.now());

    Cocktail saveCocktail = cocktailDao.insertCocktail(cocktail);
    CocktailResponseDto cocktailResponseDto = new CocktailResponseDto();
    cocktailResponseDto.setName(saveCocktail.getName());
    cocktailResponseDto.setIngredients(saveCocktail.getIngredients());
    cocktailResponseDto.setInstruction(saveCocktail.getInstruction());
    cocktailResponseDto.setAlcohol(saveCocktail.getAlcohol());
    cocktailResponseDto.setSweet(saveCocktail.getSweet());
    return cocktailResponseDto;
  }

  @Override
  public CocktailResponseDto changeCocktail(Long number, String name, String ingredients, String instruction, Float alcohol, Float sweet) throws Exception{
    Cocktail changeCocktail = cocktailDao.updateCocktail(number, name, ingredients,instruction, alcohol, sweet);

    CocktailResponseDto cocktailResponseDto = new CocktailResponseDto();
    cocktailResponseDto.setNumber(changeCocktail.getNumber());
    cocktailResponseDto.setName(changeCocktail.getName());
    cocktailResponseDto.setIngredients(changeCocktail.getIngredients());
    cocktailResponseDto.setInstruction(changeCocktail.getInstruction());
    cocktailResponseDto.setAlcohol(changeCocktail.getAlcohol());
    cocktailResponseDto.setSweet(changeCocktail.getSweet());
    return cocktailResponseDto;
  }

  @Override
  public void delectCocktail(Long number) throws Exception {
    cocktailDao.deleteCocktail(number);
  }


}