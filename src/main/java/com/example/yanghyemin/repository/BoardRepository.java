package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //전체 게시글 리스트
    List<Board> findAllBy();

    //작성일시 순 내림차순(최신순) 리스트
    List<Board> findAllByOrderByCreatedAtDesc();

    //작성자 Id 통한 게시글 리스트
    List<Board> findAllByUserId(String uId);

    //재료 통한 검색
    List<Board> findAllByRingredientsContaining(String search);

    Board getBoardById(Long id);
}
