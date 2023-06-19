package com.example.yanghyemin.dto;

import com.example.yanghyemin.entity.Cocktail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CocktailResponseDto {
  private Long number;
  private String name;
  private String ingredients;
  private String instruction;
  private String Url;
  private Float alcohol;
  private Float sweet;

  public CocktailResponseDto(Cocktail cocktail){
    this.number = cocktail.getNumber();
    this.name = cocktail.getName();
    this.ingredients = cocktail.getIngredients();
    this.instruction = cocktail.getInstruction();
    this.Url = cocktail.getUrl();
    this.alcohol = cocktail.getAlcohol();
    this.sweet = cocktail.getSweet();
  }
}
