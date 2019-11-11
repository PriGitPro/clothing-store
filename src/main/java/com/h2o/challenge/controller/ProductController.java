package com.h2o.challenge.controller;

import com.h2o.challenge.model.ProductVO;
import com.h2o.challenge.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private static Integer RATING_THRESHOLD = 2;

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public @NotNull Iterable<ProductVO> getProducts() {

        return productService.browseProducts();
    }

    @GetMapping("products/{brand}")
    public @NotNull Iterable<ProductVO> getProductsByBrand(@PathVariable String brand) {

        return productService.browseProductsByBrand(brand);
    }


    @GetMapping(value = "products", params = "status")
    public @NotNull Iterable<ProductVO> getProductsByStatus(@RequestParam String status) {
        if (status.equalsIgnoreCase("hot"))
            return productService.browseByStatus(RATING_THRESHOLD);
        return productService.browseProducts();
    }

    @GetMapping(value = "products", params = "cat")
    public @NotNull Iterable<ProductVO> getProductsByCategory(@RequestParam String cat) {
        if (!cat.isEmpty())
            return productService.browseProductsByCategory(cat);
        return productService.browseProducts();
    }

    @GetMapping(value = "products", params = "color")
    public @NotNull Iterable<ProductVO> getProductsByColor(@RequestParam String color) {
        if (!color.isEmpty())
            return productService.browseProductsByColor(color);
        return productService.browseProducts();
    }


}
