package com.example.haren201930326.dto;

import com.example.haren201930326.entity.Board;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeBoardDto {
    private Long id;
    private String title;
    private String contents;

    public ChangeBoardDto(Board board) {
        id = board.getId();
        title = board.getTitle();
        contents = board.getContents();
    }
}
