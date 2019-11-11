package com.h2o.challenge.repository;

import com.h2o.challenge.dto.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByBrand(String brand);

    @Query("SELECT p from Product p,Review r where p.id=r.pId  group by p.id having count(r.rating) >= 5 and avg(r.rating) > ?1")
    List<Product> findByAvgRating(@Param("ratingThreshold") double ratingThreshold);

    List<Product> findByCategory(String category);

    Product findByName(String name);

    @Query("SELECT distinct p from Product p,ProductItem r where p.id=r.parentId and r.color=:color")
    List<Product> findByColor(@Param("color") String color);
}
