package com.example.haren201930326.dao;

import com.example.haren201930326.entity.Product;

import java.util.List;

public interface ProductDao {
    //상품 등록
    Product insertProduct(Product product);

    //상품 수정
    Product updateProduct(Long number, String name, int price, int stock) throws Exception;

    //상품 개수 수정
    Product updateProductStock(Long number, int stock) throws Exception;

    //상품 삭제
    void deleteProduct(Long number) throws Exception;

    //전체 상품 리스트
    List<Product> listAllProduct();

    //가격 내림차순 정렬 상품 리스트
    List<Product> listProductByPrice();

    //이름 통해 가져온 상품 리스트
    List<Product> listProductByName(String name);

    //아이디를 통해 가져온 상품 정보
    Product selectProduct(Long number);

}
