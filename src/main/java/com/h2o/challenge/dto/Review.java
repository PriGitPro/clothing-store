package com.h2o.challenge.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pId;
    @NotNull
    private String reviewText;
    private Instant postedOn;
    private String postedBy;
    @NotNull
    private Integer rating;


    public Review(Long pid, @Size(max = 2000) String reviewText, @Max(5) Integer rating) {
        this.pId = pid;
        this.reviewText = reviewText;
        this.rating = rating;
    }

}
