package com.h2o.challenge.controller;

import com.h2o.challenge.model.ProductVO;
import com.h2o.challenge.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/search")
public class ProductSearchController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("")
    public @NotNull Iterable<ProductVO> getProducts(@RequestParam("text") String searchText) {

        return productService.searchProducts(searchText);
    }

}
