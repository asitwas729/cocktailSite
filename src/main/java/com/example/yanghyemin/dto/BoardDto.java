package com.example.yanghyemin.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class BoardDto {
    private String title;
    private String recipe;
    private String ringredients;
    private String url;
    private String userId;
    private String userName;
}
