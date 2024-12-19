package org.example.allrabackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.allrabackend.domain.Product;
import org.example.allrabackend.exception.product.ProductException;
import org.example.allrabackend.exception.product.ProductNotFoundException;
import org.example.allrabackend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        try {
            List<Product> products =  productRepository.findAll();

            if (products.isEmpty()) {
                log.warn("상품 목록이 비었습니다.");
                throw new ProductNotFoundException("상품 목록이 비었습니다.");
            }

            return products.stream()
                    .map(Product::from)
                    .toList();

        } catch(ProductNotFoundException e) {
            log.warn("상품을 찾을 수 없습니다 : {}", e.getMessage());
            throw e;
        } catch(Exception e) {
            log.error("상품 목록 조회 중 오류 발생 : {} " , e.getMessage(), e);
            throw new ProductException("상품 목록 조회 중 오류 발생 : " + e.getMessage());
        }
    }
}
