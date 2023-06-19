package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QIngredientsRepository extends JpaRepository<Ingredients, Long>, QuerydslPredicateExecutor<Ingredients> {
}
