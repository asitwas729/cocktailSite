package com.example.yanghyemin.dto;

public class ChangeIngredientDto {
    private Long number;
    private String name;
    private int price;
    private String url;

    public ChangeIngredientDto(Long number, String name, int price, String url) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.url = url;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
