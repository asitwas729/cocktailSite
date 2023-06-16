package com.example.yanghyemin.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="ingredients")
public class Ingredients {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long number;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private int price;

  private String url;
}
