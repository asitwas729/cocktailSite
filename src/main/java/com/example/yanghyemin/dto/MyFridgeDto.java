package com.example.yanghyemin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyFridgeDto {
  private Long ingredientsId;
  private String ingredientsName;
  private String ingredientsUrl;
  private String userId;
  private String userName;
}
