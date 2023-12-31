package com.example.yanghyemin.controller;

import com.example.yanghyemin.dto.BoardDto;
import com.example.yanghyemin.dto.BoardResponseDto;
import com.example.yanghyemin.dto.ChangeBoardDto;
import com.example.yanghyemin.dto.UserResponseDto;
import com.example.yanghyemin.security.JwtTokenProvider;
import com.example.yanghyemin.service.BoardService;
import com.example.yanghyemin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://3.39.190.51:3000")
public class BoardController {
    private final BoardService boardService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<BoardResponseDto> createBoard(HttpServletRequest request, @RequestParam String title, @RequestParam String recipe, @RequestParam String ringredients, @RequestParam String url) {
        BoardDto boardDto = new BoardDto();
        String userId = jwtTokenProvider.getUsername(request.getHeader("X-AUTH-TOKEN"));
        UserResponseDto userResponseDto = userService.userById(userId);


        boardDto.setTitle(title);
        boardDto.setRecipe(recipe);
        boardDto.setRingredients(ringredients);
        boardDto.setUrl(url);
        boardDto.setUserId(userId);
        boardDto.setUserName(userResponseDto.getName());

        System.out.println("[createBoard] 유저아이디 확인하기" + userId);

        BoardResponseDto boardResponseDto = boardService.insertBoard(boardDto);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @DeleteMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<String> deleteBoard(HttpServletRequest request, @RequestParam Long boardId) throws Exception {
        BoardResponseDto selectBoard = boardService.boardById(boardId);
        String tokenId = jwtTokenProvider.getUsername(request.getHeader("X-AUTH-TOKEN"));

        if(selectBoard.getUserId().equals(tokenId)) {
            boardService.deleteBoard(boardId);
            return ResponseEntity.status(HttpStatus.OK).body("게시글이 삭제되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("권한이 없습니다.");
        }
    }

    @PutMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<BoardResponseDto> changeBoard(HttpServletRequest request,@RequestBody ChangeBoardDto changeBoardDto) throws Exception{
        BoardResponseDto takenBoard = boardService.getOneBoard(changeBoardDto.getId());
        String id = jwtTokenProvider.getUsername(request.getHeader("X-AUTH-TOKEN"));
        if(takenBoard.getUserId().equals(id)) {
            BoardResponseDto boardResponseDTO =
                boardService.updateBoard(id, changeBoardDto);
            return ResponseEntity.status(HttpStatus.OK).body(boardResponseDTO);
        }
        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardResponseDto>> listAllBoard() {
        List<BoardResponseDto> boardResponseDtoList = boardService.listAllBoard();
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDtoList);
    }

    @GetMapping("/listOrderByCreateAt")
    public ResponseEntity<List<BoardResponseDto>> listOrderByCreatAt() {
        List<BoardResponseDto> boardResponseDtoList = boardService.listAllBoardOrderByCreateAt();
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDtoList);
    }

    @GetMapping("/byUserId")
    public ResponseEntity<List<BoardResponseDto>> listBoardByUserid(@RequestParam String uId) {
        List<BoardResponseDto> boardResponseDtoList = boardService.listAllBoardByUserId(uId);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDtoList);
    }

    @GetMapping("/")
    public ResponseEntity<BoardResponseDto> boardInfoById(@RequestParam Long id) {
        BoardResponseDto boardResponseDto = boardService.boardById(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @GetMapping("/byIngredients")
    public ResponseEntity<List<BoardResponseDto>> listBoardbyIngredients(@RequestParam String search) {
        List<BoardResponseDto> boardResponseDtoList = boardService.listAllBoardByRingredients(search);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDtoList);
    }



}
