package com.h2o.challenge.model;

import com.h2o.challenge.dto.Review;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ProductVO {
    Map<String, ?> itemKeyMapByColorBySize = new HashMap<>();
    private Long id;
    private String name;
    private Long pId;
    private String category;
    private String brand;
    private List<Review> reviews;
    private boolean isHot;
    private boolean isReviewable;
    private String shortDesc;
    private Double averageRating;
}
