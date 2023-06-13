package com.example.haren201930326.service.impl;

import com.example.haren201930326.dao.UserDao;
import com.example.haren201930326.dto.ProductResponseDto;
import com.example.haren201930326.dto.UserDto;
import com.example.haren201930326.dto.UserResponseDto;
import com.example.haren201930326.entity.Product;
import com.example.haren201930326.entity.User;
import com.example.haren201930326.repository.UserRepository;
import com.example.haren201930326.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserResponseDto userById(String uId) {
        User user = userDao.userById(uId);
        UserResponseDto userResponseDto = new UserResponseDto(user);
        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> listAllUser() {
        List<User> userList = userDao.allUser();
        List<UserResponseDto> selectUser = userList
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
        return selectUser;
    }

    @Override
    public List<UserResponseDto> listAllByNameAsc() {
        List<User> userList = userDao.listUserByNameAsc();
        List<UserResponseDto> selectUser = userList
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
        return selectUser;
    }
}
