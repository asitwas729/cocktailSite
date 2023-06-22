package com.example.yanghyemin.service;

import com.example.yanghyemin.dto.BoardDto;
import com.example.yanghyemin.dto.BoardResponseDto;
import com.example.yanghyemin.dto.ChangeBoardDto;

import java.util.List;

public interface BoardService {
    //게시글 작성
    BoardResponseDto insertBoard(BoardDto boardDto);

    //게시글 수정
    BoardResponseDto updateBoard(String uId, ChangeBoardDto changeBoardDto) throws Exception;

    //게시글 삭제
    void deleteBoard(Long id) throws Exception;
    BoardResponseDto getOneBoard(Long id);

    //전체 게시글 리스트
    List<BoardResponseDto> listAllBoard();

    //작성일시 내림차순 게시글 리스트
    List<BoardResponseDto> listAllBoardOrderByCreateAt();

    //작성자 Id별 게시글 리스트
    List<BoardResponseDto> listAllBoardByUserId(String uId);

    //게시글 id를 통한 게시글 정보
    BoardResponseDto boardById(Long id);

    //재료 통한 검색
    List<BoardResponseDto> listAllBoardByRingredients(String search);

}
