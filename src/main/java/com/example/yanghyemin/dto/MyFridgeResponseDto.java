package com.example.yanghyemin.dto;

import com.example.yanghyemin.entity.MyFridge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyFridgeResponseDto {
  private Long id;
  private Long ingredientsId;
  private String ingredientsName;
  private String ingredientsUrl;
  private String userId;
  private String userName;

  public MyFridgeResponseDto(MyFridge myFridge){
    id = myFridge.getId();
    ingredientsId = myFridge.getIngredientsId();
    ingredientsName = myFridge.getIngredientsName();
    ingredientsUrl = myFridge.getIngredientsUrl();
    userId = myFridge.getUserId();
    userName = myFridge.getUserName();
  }
}
