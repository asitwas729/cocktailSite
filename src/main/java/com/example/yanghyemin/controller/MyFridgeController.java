package com.example.yanghyemin.controller;

import com.example.yanghyemin.dto.IngredientsResponseDto;
import com.example.yanghyemin.dto.MyFridgeDto;
import com.example.yanghyemin.dto.MyFridgeResponseDto;
import com.example.yanghyemin.dto.UserResponseDto;
import com.example.yanghyemin.security.JwtTokenProvider;
import com.example.yanghyemin.service.IngredientsService;
import com.example.yanghyemin.service.MyFridgeService;
import com.example.yanghyemin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/MyFridge")
@RequiredArgsConstructor
public class MyFridgeController {
  private final MyFridgeService myFridgeService;
  private final UserService userService;
  private final IngredientsService ingredientsService;
  private final JwtTokenProvider jwtTokenProvider;

  @PostMapping()
  @PreAuthorize("hasAnyRole('ROLE_USER')")
  public ResponseEntity<MyFridgeResponseDto> insertMyFridge(HttpServletRequest request, @RequestParam Long ingredientsId, @RequestParam String ingredientsName,@RequestParam String ingredientsUrl) throws Exception {
    String userId = jwtTokenProvider.getUsername(request.getHeader("X-AUTH-TOKEN"));
    UserResponseDto userResponseDto = userService.userById(userId);

    System.out.println("[MyFridgeController] userId" + userId);

    MyFridgeDto myFridgeDto = new MyFridgeDto();
    myFridgeDto.setIngredientsId(ingredientsId);
    myFridgeDto.setIngredientsName(ingredientsName);
    myFridgeDto.setIngredientsUrl(ingredientsUrl);
    myFridgeDto.setUserId(userResponseDto.getUId());
    myFridgeDto.setUserName(userResponseDto.getName());

    MyFridgeResponseDto myFridgeResponseDto = myFridgeService.insertMyFridge(myFridgeDto);
    return ResponseEntity.status(HttpStatus.OK).body(myFridgeResponseDto);
  }


  @DeleteMapping()
  @PreAuthorize("hasAnyRole('ROLE_USER')")
  public ResponseEntity<String> deleteMyFridge(Long number) throws Exception {
    myFridgeService.deleteMyFridge(number);
    return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");

  }


  @GetMapping("/listByUserId")
  @PreAuthorize("hasAnyRole('ROLE_USER')")
  public ResponseEntity<List<MyFridgeResponseDto>> listByUserId(@RequestParam String userId) {
    List<MyFridgeResponseDto> myFridgeResponseDtoList = myFridgeService.listOrderByUserId(userId);
    return ResponseEntity.status(HttpStatus.OK).body(myFridgeResponseDtoList);
  }
}
