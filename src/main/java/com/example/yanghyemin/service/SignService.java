package com.example.haren201930326.service;

import com.example.haren201930326.dto.SignInResultDto;
import com.example.haren201930326.dto.SignUpResultDto;

public interface SignService {
    SignUpResultDto signUp(String id, String password, String name, String email, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;
}
