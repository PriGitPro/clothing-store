package com.h2o.challenge.service;

import com.h2o.challenge.dto.Item;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Validated
public interface ItemService {

    Item getItem(@Min(value = 1L, message = "Invalid Item ID.") long id);

}
