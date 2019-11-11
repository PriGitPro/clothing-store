package com.h2o.challenge.service;

import com.h2o.challenge.dto.Product;
import com.h2o.challenge.model.ProductVO;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);

    Iterable<ProductVO> browseProducts();

    Iterable<ProductVO> browseProductsByBrand(String brand);

    Iterable<ProductVO> browseProductsByCategory(String cat);

    Iterable<ProductVO> search(String text);

    Product findByName(String name);

    Iterable<ProductVO> browseByStatus(Integer ratingThreshold);

    Iterable<ProductVO> browseProductsByColor(String color);
}



