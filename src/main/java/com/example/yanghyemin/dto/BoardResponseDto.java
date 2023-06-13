package com.example.haren201930326.dto;

import com.example.haren201930326.entity.Board;
import lombok.Data;
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
