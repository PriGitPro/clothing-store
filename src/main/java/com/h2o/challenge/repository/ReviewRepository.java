package com.h2o.challenge.repository;

import com.h2o.challenge.dto.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;


public interface ReviewRepository extends CrudRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.pId = ?1")
    @NotNull Iterable<Review> getReviewsForProduct(@Param("pId") Long pId);

    @Query("SELECT r.rating FROM Review r WHERE r.pId = ?1")
    @NotNull Iterable<Long> getRatingsForProduct(@Param("pId") Long pId);

}
