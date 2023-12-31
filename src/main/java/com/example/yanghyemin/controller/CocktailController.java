package com.example.yanghyemin.controller;

import com.example.yanghyemin.dto.*;
import com.example.yanghyemin.entity.Cocktail;
import com.example.yanghyemin.service.CocktailService;
import com.example.yanghyemin.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("cocktail")
@CrossOrigin(origins = "http://3.39.190.51:3000")
public class CocktailController {
  private final CocktailService cocktailService;
  private final IngredientsService ingredientsService;

  public CocktailController(CocktailService cocktailService, IngredientsService ingredientsService) {
    this.cocktailService = cocktailService;
    this.ingredientsService = ingredientsService;
  }

  @PostMapping()
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<CocktailResponseDto> insertCocktail(HttpServletRequest request, @RequestParam String name, @RequestParam String ingredients, @RequestParam String instruction, @RequestParam String Url, @RequestParam Float alcohol, @RequestParam Float sweet) {
    CocktailDto cocktailDto = new CocktailDto();
    cocktailDto.setName(name);
    cocktailDto.setIngredients(ingredients);
    cocktailDto.setInstruction(instruction);
    cocktailDto.setUrl(Url);
    cocktailDto.setAlcohol(alcohol);
    cocktailDto.setSweet(sweet);

    CocktailResponseDto cocktailResponseDto = cocktailService.saveCocktail(cocktailDto);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDto);
  }


  @PutMapping()
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<CocktailResponseDto> updateCocktail(HttpServletRequest request, @RequestBody ChangeCocktailDto changeCocktailDto) throws Exception{
    CocktailResponseDto cocktailResponseDto = cocktailService.changeCocktail(
        changeCocktailDto.getNumber(),
        changeCocktailDto.getName(),
        changeCocktailDto.getIngredients(),
        changeCocktailDto.getInstruction(),
        changeCocktailDto.getUrl(),
        changeCocktailDto.getAlcohol(),
        changeCocktailDto.getSweet()
    );
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDto);
  }


  @DeleteMapping()
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<String> deleteCocktail(HttpServletRequest request, Long number) throws Exception {
    cocktailService.delectCocktail(number);
    return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");

  }

  @GetMapping("/list")
  public ResponseEntity<List<CocktailResponseDto>> allProduct() {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.listAllCocktail();
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/createdAt")
  public ResponseEntity<List<CocktailResponseDto>> listOrderByCocktail() {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.listAllByCreatedAtDesc();
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/byName")
  public ResponseEntity<List<CocktailResponseDto>> listByNameOrderByPrice(String name) {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.getCocktailByName(name);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/ingredients")
  public ResponseEntity<List<CocktailResponseDto>> cocktailByIngredients(String ingredients) {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.getCocktailByIngredients(ingredients);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/search")
  public ResponseEntity<List<CocktailResponseDto>> cocktailByNameAndIngredients(String search) {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.getCocktailByNameContainingAndIngredientsContaining(search);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }
  @GetMapping("/ingredientsContain")
  public ResponseEntity<List<CocktailResponseDto>> cocktailByIngredientsContain(String s1, String s2, String s3) {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.getCocktailByIngredientsOr(s1, s2, s3);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/alcohol")
  public ResponseEntity<List<CocktailResponseDto>> cocktailByAlcohol(Float alcohol) {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.getCocktailByAlcohol(alcohol);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/id")
  public ResponseEntity<CocktailResponseDto> cocktailById(Long number) {
    CocktailResponseDto cocktailResponseDtoList = cocktailService.getCocktail(number);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

//  @GetMapping("/id1")
//  public ResponseEntity<CocktailResponseDto> cocktailById1(Long number) {
//    String.valueOf(cocktailService.getCocktail(number));
//
//    IngredientsService ingredientsService = null;
//    ingredientsService.getIngredients(number);
//    CocktailResponseDto cocktailResponseDtoList = cocktailService.getCocktail(number);
//    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
//  }

}
