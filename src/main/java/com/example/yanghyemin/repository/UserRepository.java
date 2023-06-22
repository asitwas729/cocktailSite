package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User getByUid(String uid);
    List<User> findAll();
    List<User> findAllByOrderByNameAsc();
    Optional<User> findByEmail(String email);

}