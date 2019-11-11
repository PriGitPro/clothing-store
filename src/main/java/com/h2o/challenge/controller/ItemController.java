package com.h2o.challenge.controller;

import com.h2o.challenge.dto.Item;
import com.h2o.challenge.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = {"", "{pName}/{id}"})
    public @NotNull Item getItem(@PathVariable String pName, @PathVariable Long id) {

        return itemService.getItem(id);
    }


}
