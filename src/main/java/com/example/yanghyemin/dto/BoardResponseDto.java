package com.example.yanghyemin.dto;

import com.example.yanghyemin.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String recipe;
    private String ringredients;
    private String url;
    private String userId;
    private String userName;
    private LocalDateTime createAt;

    public BoardResponseDto(Board board){
        id = board.getId();
        title = board.getTitle();
        recipe = board.getRecipe();
        ringredients = board.getRingredients();
        url = board.getUrl();
        userId = board.getUserId();
        userName = board.getUserName();
        createAt = board.getCreatedAt();
    }
    public BoardResponseDto(long id, String title, String recipe, String ringredients, String url, String userId, String userName) {
        this.id = id;
        this.title = title;
        this.recipe = recipe;
        this.ringredients = ringredients;
        this.url = url;
        this.userId = userId;
        this.userName = userName;
    }
}
