package com.example.yanghyemin.dao.impl;

import com.example.yanghyemin.dao.UserDao;
import com.example.yanghyemin.entity.User;
import com.example.yanghyemin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;

    @Override
    public User userById(String uId) {
        User user = userRepository.getByUid(uId);
        return user;
    }

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> allUser() {
        List<User> allUser = userRepository.findAll();
        return allUser;
    }

    @Override
    public List<User> listUserByNameAsc() {
        List<User> userList = userRepository.findAllByOrderByNameAsc();
        return userList;
    }
}
