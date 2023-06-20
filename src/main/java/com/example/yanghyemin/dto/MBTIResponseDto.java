package com.example.yanghyemin.dto;

import com.example.yanghyemin.entity.MBTI;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MBTIResponseDto {
  private Long number;
  private String mbti;
  private String name;
  private String keyword;
  private String ex;
  private String best;
  private String worst;
  private String url;
  public MBTIResponseDto(MBTI mbti){
    this.number = mbti.getNumber();
    this.mbti = mbti.getMbti();
    this.name = mbti.getName();
    this.keyword = mbti.getKeyword();
    this.ex = mbti.getEx();
    this.best = mbti.getBest();
    this.worst = mbti.getWorst();
    this.url = mbti.getUrl();
  }
}
