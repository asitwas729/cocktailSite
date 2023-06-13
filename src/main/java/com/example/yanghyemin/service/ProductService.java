package com.example.haren201930326.service;

import com.example.haren201930326.dto.ProductDto;
import com.example.haren201930326.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    //상품 번호를 통해 상품 정보를 가지고 온다.
    ProductResponseDto getProduct(Long number);

    //이름을 통해 가져온 상품 리스트
    List<ProductResponseDto> getProductByName(String name);

    //전체 상품 리스트
    List<ProductResponseDto> listAllProduct();

    //가격순 내림차순 정렬 상품 리스트
    List<ProductResponseDto> listAllByPriceDesc();

    //CRUD
    //등록할 상품
    ProductResponseDto saveProduct(ProductDto productDto);

    //상품 삭제
    void deleteProduct(Long number) throws Exception;

    //상품 수정
    ProductResponseDto changeProduct(Long number, String name, int price, int stock) throws Exception;

    ProductResponseDto changeProductStock(Long number, int stock) throws Exception;
}