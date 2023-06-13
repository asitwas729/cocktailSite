package com.example.yanghyemin.dto;

import com.example.yanghyemin.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
