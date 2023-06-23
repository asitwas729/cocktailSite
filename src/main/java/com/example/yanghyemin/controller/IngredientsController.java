package com.example.yanghyemin.controller;

import com.example.yanghyemin.dto.*;
import com.example.yanghyemin.security.JwtTokenProvider;
import com.example.yanghyemin.service.CocktailService;
import com.example.yanghyemin.service.IngredientsService;
import com.example.yanghyemin.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("ingredients")
@CrossOrigin(origins = "http://3.39.190.51:3000")
public class IngredientsController {
    private final IngredientsService ingredientsService;
    private final CocktailService cocktailService;
    private final JwtTokenProvider jwtTokenProvider;


    public IngredientsController(IngredientsService ingredientsService, CocktailService cocktailService, JwtTokenProvider jwtTokenProvider) {
        this.ingredientsService = ingredientsService;
        this.cocktailService = cocktailService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<IngredientsResponseDto> insertIngredients(HttpServletRequest request, @RequestParam String name, @RequestParam Integer price, @RequestParam String url) {
        IngredientsDto ingredientsDto = new IngredientsDto();

        jwtTokenProvider.getAuthenication(request.getHeader("X-AUTH-TOKEN"));
        ingredientsDto.setName(name);
        ingredientsDto.setPrice(price);
        ingredientsDto.setUrl(url);

        IngredientsResponseDto ingredientsResponseDto = ingredientsService.saveIngredients(ingredientsDto);
        return ResponseEntity.status(HttpStatus.OK).body(ingredientsResponseDto);
    }


    @PutMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<IngredientsResponseDto> updateIngredients(HttpServletRequest request, @RequestBody ChangeIngredientDto changeIngredientDto) throws Exception{
        IngredientsResponseDto ingredientsResponseDto = ingredientsService.changeIngredients(
            changeIngredientDto.getNumber(),
            changeIngredientDto.getName(),
            changeIngredientDto.getPrice(),
            changeIngredientDto.getUrl()
        );
        return ResponseEntity.status(HttpStatus.OK).body(ingredientsResponseDto);
    }


    @DeleteMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteIngredients(HttpServletRequest request, Long number) throws Exception {
        ingredientsService.deleteIngredients(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");

    }

    @GetMapping("/list")
    public ResponseEntity<List<IngredientsResponseDto>> allIngredients() {
        List<IngredientsResponseDto> ingredientsResponseDtoList = ingredientsService.listAllIngredients();
        return ResponseEntity.status(HttpStatus.OK).body(ingredientsResponseDtoList);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<IngredientsResponseDto>> allIngredientss(String cocktailname) {
        CocktailResponseDto cocktailResponseDto = cocktailService.getCocktailName(cocktailname);
        String str = cocktailResponseDto.getIngredients();
        String[] sp = str.split(",");
        String[] sp2 = null;
        for(int i=0; i<sp.length; i++){
            sp2[i] = String.valueOf(ingredientsService.getIngredientsName(sp[i]));
            System.out.println(sp2[i]);
        }
        return null;
    }

    @GetMapping("/byName")
    public ResponseEntity<List<IngredientsResponseDto>> listByName(String name) {
        List<IngredientsResponseDto> ingredientsResponseDtoList = ingredientsService.getIngredientsByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(ingredientsResponseDtoList);
    }

    @GetMapping("/")
    public ResponseEntity<IngredientsResponseDto> productById(Long number) {
        IngredientsResponseDto ingredientsResponseDto = ingredientsService.getIngredients(number);
        return ResponseEntity.status(HttpStatus.OK).body(ingredientsResponseDto);
    }
}
