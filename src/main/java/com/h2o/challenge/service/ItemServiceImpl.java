package com.h2o.challenge.service;

import com.h2o.challenge.dto.Item;
import com.h2o.challenge.exception.ResourceNotFoundException;
import com.h2o.challenge.repository.ItemRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Cacheable
    public Item getItem(long id) {
        return itemRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

}
