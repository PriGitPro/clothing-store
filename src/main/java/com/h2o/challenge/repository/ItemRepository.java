package com.h2o.challenge.repository;

import com.h2o.challenge.dto.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
