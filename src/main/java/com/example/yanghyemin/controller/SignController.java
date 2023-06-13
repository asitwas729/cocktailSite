package com.example.yanghyemin.controller;

import com.example.yanghyemin.dto.SignInResultDto;
import com.example.yanghyemin.dto.SignUpResultDto;
import com.example.yanghyemin.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign-api")
public class SignController {
    private final SignService signService;

    @Autowired
    public SignController(SignService signService) {
        this.signService = signService;
    }

    @PostMapping("/sing-in")
    public SignInResultDto signIn(@RequestParam String id, @RequestParam String password) throws RuntimeException {
        SignInResultDto signInResultDto = signService.signIn(id, password);
        if(signInResultDto.getCode() == 0) {
            System.out.println("[SignIn] 정상적으로 로그인되었습니다. "+ signInResultDto.getToken());
        }
        return signInResultDto;
    }
    @PostMapping("/sing-up")
    public SignUpResultDto signUp(@RequestParam String id, @RequestParam String password, @RequestParam String name, @RequestParam String email, @RequestParam String role) throws RuntimeException {
        SignUpResultDto signUpResultDto = signService.signUp(id, password, name,email, role);
        return signUpResultDto;
    }

    @GetMapping("/exception")
    public void exception() throws RuntimeException {
        throw new RuntimeException("접근이 금지되었습니다.");
    }
}
