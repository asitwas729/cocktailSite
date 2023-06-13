package com.example.haren201930326.repository;

import com.example.haren201930326.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QUserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
}
