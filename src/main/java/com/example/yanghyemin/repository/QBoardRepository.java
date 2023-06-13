package com.example.haren201930326.repository;

import com.example.haren201930326.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QBoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {
}
