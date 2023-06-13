package com.example.haren201930326.dao.impl;

import com.example.haren201930326.dao.BoardDao;
import com.example.haren201930326.dto.ChangeBoardDto;
import com.example.haren201930326.entity.Board;
import com.example.haren201930326.repository.BoardRepository;
import com.example.haren201930326.repository.QBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.haren201930326.entity.QBoard.board;

@Component
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao {
    private final BoardRepository boardRepository;
    private final QBoardRepository qBoardRepository;

    @Override
    public Board insertBoard(Board board) {
        Board saveBoard = boardRepository.save(board);
        return saveBoard;
    }

    @Override
    public Board updateBoard(String uId, ChangeBoardDto changeBoardDto) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(changeBoardDto.getId());
        Board updateBoard;
        if(selectedBoard.isPresent()) {
            Board board = selectedBoard.get();
            board.setTitle(changeBoardDto.getTitle());
            board.setContents(changeBoardDto.getContents());
            board.setUpdatedAt(LocalDateTime.now());
            updateBoard = boardRepository.save(board);
        } else throw new Exception();
        return updateBoard;
    }

    @Override
    public void deleteBoard(Long id) throws Exception{
        Optional<Board> selectedBoard = boardRepository.findById(id);
        if(selectedBoard.isPresent()) {
            Board board = selectedBoard.get();
            boardRepository.delete(board);
        } else throw new Exception();
    }

    @Override
    public List<Board> listAllBoard() {
        List<Board> boardList = boardRepository.findAllBy();
        return boardList;
    }

    @Override
    public List<Board> listAllBoardOrderByCreateAt() {
        List<Board> boardList = boardRepository.findAllByOrderByCreatedAtDesc();
        return boardList;
    }

    @Override
    public List<Board> listAllBoardByUserId(String uId) {
        List<Board> boardList = boardRepository.findAllByUserId(uId);
        return boardList;
    }

    @Override
    public Board boardById(Long id) {
        Board board = boardRepository.getBoardById(id);
        return board;
    }
}
