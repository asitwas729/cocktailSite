package com.example.haren201930326.dao.impl;

import com.example.haren201930326.dao.ProductDao;
import com.example.haren201930326.entity.Product;
import com.example.haren201930326.repository.ProductRepository;
import com.example.haren201930326.repository.QProductRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.haren201930326.entity.QProduct.product;

@Component
public class ProductDaoImpl implements ProductDao {
    private final ProductRepository productRepository;
    private final QProductRepository qProductRepository;

    @Autowired
    public ProductDaoImpl(ProductRepository productRepository, QProductRepository qProductRepository) {
        this.productRepository = productRepository;
        this.qProductRepository = qProductRepository;
    }

    @Override
    public Product selectProduct(Long number) {
        Predicate predicate = product.number.eq(number);
        Optional<Product> selectProduct = qProductRepository.findOne(predicate);

        return selectProduct.isPresent() ? selectProduct.get() : null;
    }

    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public Product updateProduct(Long number, String name, int price, int stock) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);
        Product updateProduct;

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            product.setUpdatedAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else throw new Exception();

        return updateProduct;
    }

    @Override
    public Product updateProductStock(Long number, int stock) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);
        Product updateProduct;

        if(selectProduct.isPresent()) {
            Product product = selectProduct.get();
            product.setStock(stock-1);
            product.setUpdatedAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else throw new Exception();

        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else throw new Exception();
    }

    @Override
    public List<Product> listAllProduct() {
        List<Product> allProduct = productRepository.findAll();
        return allProduct;
    }

    @Override
    public List<Product> listProductByPrice() {
        List<Product> selectProduct = productRepository.findAllByOrderByPriceDesc();
        return selectProduct;
    }

    @Override
    public List<Product> listProductByName(String name) {
        List<Product> selectProduct = productRepository.findByName(name);
        return selectProduct;
    }


}