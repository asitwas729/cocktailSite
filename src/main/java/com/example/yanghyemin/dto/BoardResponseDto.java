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
    private String contents;
    private String userId;
    private String userName;
    private LocalDateTime createAt;

    public BoardResponseDto(Board board){
        id = board.getId();
        title = board.getTitle();
        contents = board.getContents();
        userId = board.getUserId();
        userName = board.getUserName();
        createAt = board.getCreatedAt();
    }
}
