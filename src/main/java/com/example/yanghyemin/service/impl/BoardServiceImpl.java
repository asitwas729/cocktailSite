package com.example.haren201930326.service.impl;

import com.example.haren201930326.dao.BoardDao;
import com.example.haren201930326.dto.BoardDto;
import com.example.haren201930326.dto.BoardResponseDto;
import com.example.haren201930326.dto.ChangeBoardDto;
import com.example.haren201930326.entity.Board;
import com.example.haren201930326.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDao boardDao;

    @Override
    public BoardResponseDto insertBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContents(boardDto.getContents());
        board.setUserId(boardDto.getUserId());
        board.setUserName(boardDto.getUserName());
        board.setCreatedAt(LocalDateTime.now());

        Board saveBoard = boardDao.insertBoard(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setTitle(saveBoard.getTitle());
        boardResponseDto.setContents(saveBoard.getContents());
        boardResponseDto.setUserId(saveBoard.getUserId());
        boardResponseDto.setUserName(saveBoard.getUserName());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto updateBoard(String uId, ChangeBoardDto changeBoardDto) throws Exception {
        Board updateBoard = boardDao.updateBoard(uId, changeBoardDto);
        return new BoardResponseDto(updateBoard);
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        boardDao.deleteBoard(id);
    }

    @Override
    public List<BoardResponseDto> listAllBoard() {
        List<Board> boardList = boardDao.listAllBoard();
        List<BoardResponseDto> boardResponseDtoList = boardList
                .stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
        return boardResponseDtoList;
    }

    @Override
    public List<BoardResponseDto> listAllBoardOrderByCreateAt() {
        List<Board> boardList = boardDao.listAllBoardOrderByCreateAt();
        List<BoardResponseDto> boardResponseDtoList = boardList
                .stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
        return boardResponseDtoList;
    }

    @Override
    public List<BoardResponseDto> listAllBoardByUserId(String uId) {
        List<Board> boardList = boardDao.listAllBoardByUserId(uId);
        List<BoardResponseDto> boardResponseDtoList = boardList
                .stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
        return boardResponseDtoList;
    }

    @Override
    public BoardResponseDto boardById(Long id) {
        Board board = boardDao.boardById(id);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(board.getId());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContents(board.getContents());
        boardResponseDto.setUserId(board.getUserId());
        boardResponseDto.setUserName(board.getUserName());

        return boardResponseDto;
    }
}
