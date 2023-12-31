package com.example.yanghyemin.dto;


public class ChangeCocktailDto {
  private Long number;
  private String name;
  private String ingredients;
  private String instruction;
  private String url;
  private Float alcohol;
  private Float sweet;

  public ChangeCocktailDto(Long number, String name, String ingredients, String instruction, String url, Float alcohol, Float sweet) {
    this.number = number;
    this.name = name;
    this.ingredients = ingredients;
    this.instruction = instruction;
    this.url = url;
    this.alcohol = alcohol;
    this.sweet = sweet;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }

  public Float getAlcohol() {
    return alcohol;
  }

  public void setAlcohol(Float alcohol) {
    this.alcohol = alcohol;
  }

  public Float getSweet() {
    return sweet;
  }

  public void setSweet(Float sweet) {
    this.sweet = sweet;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
