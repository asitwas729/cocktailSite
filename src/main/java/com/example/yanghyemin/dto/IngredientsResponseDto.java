package com.example.yanghyemin.dto;

import com.example.yanghyemin.entity.Ingredients;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientsResponseDto {
    private Long number;
    private String name;
    private int price;
    private String url;

    public IngredientsResponseDto(Ingredients ingredients) {
        this.number = ingredients.getNumber();
        this.name = ingredients.getName();
        this.price = ingredients.getPrice();
        this.url = ingredients.getUrl();
    }
}
