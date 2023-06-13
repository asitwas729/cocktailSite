package com.example.haren201930326.controller;

import com.example.haren201930326.dto.ChangeProductDto;
import com.example.haren201930326.dto.ProductDto;
import com.example.haren201930326.dto.ProductResponseDto;
import com.example.haren201930326.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<ProductResponseDto> insertProduct(@RequestParam String productName, @RequestParam int price, @RequestParam int stock) {
        ProductDto productDto = new ProductDto();
        productDto.setName(productName);
        productDto.setPrice(price);
        productDto.setStock(stock);

        ProductResponseDto productResponseDto = productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }


    @PutMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody ChangeProductDto changeProductDto) throws Exception{
        ProductResponseDto productResponseDto = productService.changeProduct(
                changeProductDto.getNumber(),
                changeProductDto.getName(),
                changeProductDto.getPrice(),
                changeProductDto.getStock()
        );
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }


    @DeleteMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");

    }

    @GetMapping("/list")
    @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<ProductResponseDto>> allProduct() {
        List<ProductResponseDto> productResponseDtoList = productService.listAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDtoList);
    }

    @GetMapping("/listOrderByPrice")
    @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<ProductResponseDto>> listOrderByProduct() {
        List<ProductResponseDto> productResponseDtoList = productService.listAllByPriceDesc();
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDtoList);
    }

    @GetMapping("/byName")
    @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<ProductResponseDto>> listByNameOrderByPrice(String name) {
        List<ProductResponseDto> productResponseDtoList = productService.getProductByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDtoList);
    }

    @GetMapping("/")
    @PreAuthorize("isAnonymous() or hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<ProductResponseDto> productById(Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }


}
