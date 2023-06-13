package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QUserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
}
