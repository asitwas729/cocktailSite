package com.example.yanghyemin.service.impl;

import com.example.yanghyemin.dao.ProductDao;
import com.example.yanghyemin.dto.ProductDto;
import com.example.yanghyemin.dto.ProductResponseDto;
import com.example.yanghyemin.entity.Product;
import com.example.yanghyemin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;


    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDao.selectProduct(number);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> getProductByName(String name) {
        List<Product> product = productDao.listProductByName(name);
        List<ProductResponseDto> selectProduct = product
                .stream()
                .map(ProductResponseDto::new)
                .collect(Collectors.toList());
        return selectProduct;
    }

    @Override
    public List<ProductResponseDto> listAllProduct() {
        List<Product> products = productDao.listAllProduct();
        List<ProductResponseDto> selectProduct = products
                .stream()
                .map(ProductResponseDto::new)
                .collect(Collectors.toList());
        return selectProduct;
    }

    @Override
    public List<ProductResponseDto> listAllByPriceDesc() {
        List<Product> products = productDao.listProductByPrice();
        List<ProductResponseDto> selectProduct = products
                .stream()
                .map(ProductResponseDto::new)
                .collect(Collectors.toList());
        return selectProduct;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productDao.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setNumber(saveProduct.getNumber());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDao.deleteProduct(number);
    }

    @Override
    public ProductResponseDto changeProduct(Long number, String name, int price, int stock) throws Exception {
        Product changeProduct = productDao.updateProduct(number, name, price, stock);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(changeProduct.getName());
        productResponseDto.setNumber(changeProduct.getNumber());
        productResponseDto.setPrice(changeProduct.getPrice());
        productResponseDto.setStock(changeProduct.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductStock(Long number, int stock) throws Exception {
        Product changeProduct = productDao.updateProductStock(number, stock);
        return new ProductResponseDto(changeProduct);
    }
}
