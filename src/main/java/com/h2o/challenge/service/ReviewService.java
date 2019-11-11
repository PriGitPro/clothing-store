package com.h2o.challenge.service;

import com.h2o.challenge.dto.Review;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface ReviewService {

    @NotNull Iterable<Review> getReviewsForProduct(Long pId);

    Review save(Review r);
}
