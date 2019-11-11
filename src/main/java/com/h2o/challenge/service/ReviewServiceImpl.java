package com.h2o.challenge.service;

import com.h2o.challenge.dto.Review;
import com.h2o.challenge.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public @NotNull Iterable<Review> getReviewsForProduct(Long pId) {
        return reviewRepository.getReviewsForProduct(pId);
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }
}
