package com.example.yanghyemin.service;

import com.example.yanghyemin.dto.SignInResultDto;
import com.example.yanghyemin.dto.SignUpResultDto;

public interface SignService {
    SignUpResultDto signUp(String id, String password, String name, String email, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;
}
