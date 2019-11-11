package com.h2o.challenge.repository;

import com.h2o.challenge.dto.ProductItem;
import org.springframework.data.repository.CrudRepository;

public interface ProductItemRepository extends CrudRepository<ProductItem, Long> {
}
