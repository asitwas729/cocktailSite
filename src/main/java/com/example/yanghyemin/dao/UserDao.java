package com.example.haren201930326.dao;

import com.example.haren201930326.entity.User;

import java.util.List;

public interface UserDao {

    User userById(String uId);
    //모든 유저 리스트
    List<User> allUser();
    //이름 오름차순 유저 리스트
    List<User> listUserByNameAsc();
}
