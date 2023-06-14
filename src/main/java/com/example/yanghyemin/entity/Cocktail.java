package com.example.yanghyemin.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="cocktail")
public class Cocktail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cvsId")
  private Long number;

  @Column(name = "cvsName", nullable = false)
  private String name;

  @Column(name = "cvsIngredients", nullable = false)
  private String ingredients;
  @Column(name = "cvsInstruction", nullable = false)
  private String instruction;
  @Column(name = "cvsdate", nullable = false)
  private LocalDateTime createdAt;
  @Column(name = "cvsAlcohol")
  private Float alcohol;
  @Column(name = "cvsSweet")
  private Float sweet;


}