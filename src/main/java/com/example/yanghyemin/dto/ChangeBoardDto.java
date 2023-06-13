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
    private String contents;

    public ChangeBoardDto(Board board) {
        id = board.getId();
        title = board.getTitle();
        contents = board.getContents();
    }
}
