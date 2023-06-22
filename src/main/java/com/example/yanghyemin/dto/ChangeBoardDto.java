package com.example.yanghyemin.dto;

import com.example.yanghyemin.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeBoardDto {
    private Long id;
    private String title;
    private String recipe;
    private String ringredients;
    private String url;

    public ChangeBoardDto(Board board) {
        id = board.getId();
        title = board.getTitle();
        recipe = board.getRecipe();
        ringredients = board.getRingredients();
        url = board.getUrl();
    }
}
