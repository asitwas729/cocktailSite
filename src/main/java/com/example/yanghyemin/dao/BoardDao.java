package com.example.yanghyemin.dao;

import com.example.yanghyemin.dto.ChangeBoardDto;
import com.example.yanghyemin.entity.Board;

import java.util.List;

public interface BoardDao {
    //게시글 등록
    Board insertBoard(Board board);

    //게시글 수정
    Board updateBoard(String uId, ChangeBoardDto changeBoardDto) throws Exception;

    //게시글 삭제
    void deleteBoard(Long id) throws Exception;

    //전체 리스트
    List<Board> listAllBoard();

    //작성일시순 내림차순 리스트
    List<Board> listAllBoardOrderByCreateAt();

    //작성자 Id 통한 게시글 리스트
    List<Board> listAllBoardByUserId(String uId);

    //게시글 Id 통한 게시글 정보
    Board boardById(Long id);

    //재료 통한 검색
    List<Board> listAllBoardByRingredients(String search);

}
