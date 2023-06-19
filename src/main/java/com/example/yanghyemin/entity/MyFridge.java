package com.example.yanghyemin.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Builder
@Table(name = "myfridge")
public class MyFridge {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private Long ingredientsId;
  @Column(nullable = false)
  private String ingredientsName;
  @Column(nullable = false)
  private String ingredientsUrl;
  @Column(nullable = false)
  private String userId;
  @Column(nullable = false)
  private String userName;
  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

}
