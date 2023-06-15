package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.Cocktail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CocktailRepositoryTest {
  @Autowired
  private CocktailRepository cocktailRepository;

  @Test
  public void findByNameContainingOrIngredientsContaining() {

  }
}