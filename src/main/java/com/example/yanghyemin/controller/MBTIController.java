package com.example.yanghyemin.controller;

import com.example.yanghyemin.dto.CocktailResponseDto;
import com.example.yanghyemin.dto.MBTIResponseDto;
import com.example.yanghyemin.service.MBTIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mbti")
@CrossOrigin(origins = "http://3.39.190.51:3000")
public class MBTIController {
  private final MBTIService mbtiService;

  @Autowired
  public MBTIController(MBTIService mbtiService) {
    this.mbtiService = mbtiService;
  }
  @GetMapping("/list")
  public ResponseEntity<List<MBTIResponseDto>> allProduct() {
    List<MBTIResponseDto> mbtiResponseDtoList = mbtiService.listAllMBTI();
    return ResponseEntity.status(HttpStatus.OK).body(mbtiResponseDtoList);
  }
}
