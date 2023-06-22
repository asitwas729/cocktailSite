package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QBoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {
}
