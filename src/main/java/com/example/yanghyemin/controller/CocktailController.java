package com.example.yanghyemin.controller;

import com.example.yanghyemin.dto.*;
import com.example.yanghyemin.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cocktail")
public class CocktailController {
  private final CocktailService cocktailService;

  @Autowired
  public CocktailController(CocktailService cocktailService) {
    this.cocktailService = cocktailService;
  }

  @PostMapping()
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<CocktailResponseDto> insertCocktail(@RequestParam String name, @RequestParam String ingredients, @RequestParam String instruction, @RequestParam Float alcohol, @RequestParam Float sweet) {
    CocktailDto cocktailDto = new CocktailDto();
    cocktailDto.setName(name);
    cocktailDto.setIngredients(ingredients);
    cocktailDto.setInstruction(instruction);
    cocktailDto.setAlcohol(alcohol);
    cocktailDto.setSweet(sweet);

    CocktailResponseDto cocktailResponseDto = cocktailService.saveCocktail(cocktailDto);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDto);
  }


  @PutMapping()
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<CocktailResponseDto> updateCocktail(@RequestBody ChangeCocktailDto changeCocktailDto) throws Exception{
    CocktailResponseDto cocktailResponseDto = cocktailService.changeCocktail(
        changeCocktailDto.getNumber(),
        changeCocktailDto.getName(),
        changeCocktailDto.getIngredients(),
        changeCocktailDto.getInstruction(),
        changeCocktailDto.getAlcohol(),
        changeCocktailDto.getSweet()
    );
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDto);
  }


  @DeleteMapping()
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<String> deleteCocktail(Long number) throws Exception {
    cocktailService.delectCocktail(number);
    return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");

  }

  @GetMapping("/list")
  @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  public ResponseEntity<List<CocktailResponseDto>> allProduct() {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.listAllCocktail();
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/createdAt")
  @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  public ResponseEntity<List<CocktailResponseDto>> listOrderByCocktail() {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.listAllByCreatedAtDesc();
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/byName")
  @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  public ResponseEntity<List<CocktailResponseDto>> listByNameOrderByPrice(String name) {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.getCocktailByName(name);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/ingredients")
  @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  public ResponseEntity<List<CocktailResponseDto>> cocktailByIngredients(String ingredients) {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.getCocktailByIngredients(ingredients);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/search")
  @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  public ResponseEntity<List<CocktailResponseDto>> cocktailByNameAndIngredients(String search) {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.getCocktailByNameContainingAndIngredientsContaining(search);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/alcohol")
  @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  public ResponseEntity<List<CocktailResponseDto>> cocktailByAlcohol(Float alcohol) {
    List<CocktailResponseDto> cocktailResponseDtoList = cocktailService.getCocktailByAlcohol(alcohol);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }

  @GetMapping("/")
  @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  public ResponseEntity<CocktailResponseDto> cocktailById(Long number) {
    CocktailResponseDto cocktailResponseDtoList = cocktailService.getCocktail(number);
    return ResponseEntity.status(HttpStatus.OK).body(cocktailResponseDtoList);
  }
}
