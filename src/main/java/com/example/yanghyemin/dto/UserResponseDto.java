package com.example.haren201930326.dto;

import com.example.haren201930326.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String uId;
    private String name;
    private String email;

    public UserResponseDto(User user){
        uId = user.getUid();
        name = user.getName();
        email = user.getEmail();
    }
}
