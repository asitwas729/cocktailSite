package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.MBTI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QMBTIRepository extends JpaRepository<MBTI, Long>, QuerydslPredicateExecutor<MBTI> {
}
