package com.example.yanghyemin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CocktailDto {
  private String name;
  private String ingredients;
  private String instruction;
  private Float alcohol;
  private Float sweet;
  private String url;
}