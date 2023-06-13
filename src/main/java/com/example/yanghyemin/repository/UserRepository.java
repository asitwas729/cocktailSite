package com.example.haren201930326.repository;

import com.example.haren201930326.entity.Product;
import com.example.haren201930326.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User getByUid(String uid);
    List<User> findAll();
    List<User> findAllByOrderByNameAsc();

}