package com.example.yanghyemin.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="mbti")
public class MBTI {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long number;
  @Column(nullable = false)
  private String mbti;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String keyword;
  @Column(nullable = false)
  private String ex;
  @Column(nullable = false)
  private String best;
  @Column(nullable = false)
  private String worst;
  private String url;
}
