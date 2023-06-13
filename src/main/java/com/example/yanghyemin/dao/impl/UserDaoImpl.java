package com.example.haren201930326.dao.impl;

import com.example.haren201930326.dao.UserDao;
import com.example.haren201930326.entity.Product;
import com.example.haren201930326.entity.User;
import com.example.haren201930326.repository.QUserRepository;
import com.example.haren201930326.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
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
