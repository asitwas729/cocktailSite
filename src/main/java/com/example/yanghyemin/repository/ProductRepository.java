package com.example.yanghyemin.repository;

import com.example.yanghyemin.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //전체 상품 리스트
    List<Product> findAll();

    //가격순 내림차순 정렬 상품 리스트
    List<Product> findAllByOrderByPriceDesc();

    //상품명 통해 가져온 상품 리스트
    List<Product> findByName(String name);

}
