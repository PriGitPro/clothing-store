package com.h2o.challenge;

import com.h2o.challenge.dto.Item;
import com.h2o.challenge.dto.Product;
import com.h2o.challenge.dto.ProductItem;
import com.h2o.challenge.dto.Review;
import com.h2o.challenge.repository.ItemRepository;
import com.h2o.challenge.repository.ProductItemRepository;
import com.h2o.challenge.service.ProductService;
import com.h2o.challenge.service.ReviewService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService, ReviewService reviewService, ItemRepository itemService, ProductItemRepository pItemMap) {
        return args -> {


            Product p1 = new Product();
            p1.setName("gap-full-sleeve-shirt");
            p1.setPId(1L);
            p1.setCategory("shirt");
            p1.setBrand("gap");

            Product saved = productService.save(p1);

            Review r = new Review(saved.getId(), "testing review", 1);
            reviewService.save(r);
            r = new Review(saved.getId(), "testing review", 1);
            reviewService.save(r);
            r = new Review(saved.getId(), "testing review", 1);
            reviewService.save(r);
            r = new Review(saved.getId(), "testing review", 2);
            reviewService.save(r);
            r = new Review(saved.getId(), "testing review", 2);
            reviewService.save(r);

            p1 = new Product();
            p1.setName("gap-half-sleeve-shirt");

            //p1.setAvailableColorFamilySet(colors);
            p1.setCategory("shirt");
            p1.setBrand("gap");

            // p1.getItemKeyMapByColorBySize().put("red",colMap);
            saved = productService.save(p1);


            Item i = new Item(null, "gap-full-sleev-shirt", 1l, "this is a short sleeve shirt", "this shirt in color red is a perfect addition to your wardrobe", null, null, "red", "M", 100.0);
            itemService.save(i);
            i = new Item(null, "gap-full-sleev-shirt", 1l, "this is a short sleeve shirt", "this shirt in color red is a perfect addition to your wardrobe", null, null, "red", "L", 100.0);
            itemService.save(i);
            i = new Item(null, "gap-full-sleev-shirt", 1l, "this is a short sleeve shirt", "this shirt in color red is a perfect addition to your wardrobe", null, null, "black", "L", 100.0);
            itemService.save(i);
            i = new Item(null, "gap-full-sleev-shirt", 1l, "this is a short sleeve shirt", "this shirt in color red is a perfect addition to your wardrobe", null, null, "red", "S", 100.0);
            itemService.save(i);
            i = new Item(null, "gap-half-sleev-shirt", 2l, "this is a short sleeve shirt", "this shirt in color red is a perfect addition to your wardrobe", null, null, "black", "S", 100.0);
            itemService.save(i);
            i = new Item(null, "gap-half-sleev-shirt", 2l, "this is a short sleeve shirt", "this shirt in color red is a perfect addition to your wardrobe", null, null, "blue", "L", 100.0);
            itemService.save(i);
            i = new Item(null, "gap-half-sleev-shirt", 2l, "this is a short sleeve shirt", "this shirt in color red is a perfect addition to your wardrobe", null, null, "red", "L", 100.0);
            itemService.save(i);

            r = new Review(saved.getId(), "testing review", 4);
            reviewService.save(r);

            r = new Review(saved.getId(), "testing review", 4);
            reviewService.save(r);
            r = new Review(saved.getId(), "testing review", 4);
            reviewService.save(r);
            r = new Review(saved.getId(), "testing review", 4);
            reviewService.save(r);
            r = new Review(saved.getId(), "testing review", 4);
            reviewService.save(r);
            r = new Review(saved.getId(), "testing review", 4);
            reviewService.save(r);
//Mapping of product to individual article
// Only one item for each color-size combo, inventory may have thousands of articles/more quantities
            ProductItem pi = new ProductItem(1l, 1l, 1l, "red", "M");
            pItemMap.save(pi);
            pi = new ProductItem(2l, 1l, 2l, "red", "L");
            pItemMap.save(pi);
            pi = new ProductItem(3l, 1l, 3l, "black", "L");
            pItemMap.save(pi);
            pi = new ProductItem(4l, 2l, 4l, "red", "S");
            pItemMap.save(pi);
            pi = new ProductItem(5l, 2l, 5l, "black", "S");
            pItemMap.save(pi);
            pi = new ProductItem(6l, 2l, 6l, "blue", "L");
            pItemMap.save(pi);


        };
    }
}
