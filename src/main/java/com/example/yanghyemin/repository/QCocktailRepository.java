package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QCocktailRepository extends JpaRepository<Cocktail, Long>, QuerydslPredicateExecutor<Cocktail> {
}
