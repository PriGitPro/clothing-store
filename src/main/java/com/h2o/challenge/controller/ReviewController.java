package com.h2o.challenge.controller;

import com.h2o.challenge.dto.Review;
import com.h2o.challenge.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(value = {"", "/"})
    public @NotNull Iterable<Review> getReviews(@RequestParam Long pId) {

        return reviewService.getReviewsForProduct(pId);
    }


}
