package com.h2o.challenge.service;

import com.h2o.challenge.dto.Product;
import com.h2o.challenge.exception.ResourceNotFoundException;
import com.h2o.challenge.model.ProductVO;
import com.h2o.challenge.repository.ProductRepository;
import com.h2o.challenge.repository.ProductSearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductSearchDao productSearchDao;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }


    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Iterable<ProductVO> browseProducts() {

        return StreamSupport.stream(productRepository.findAll().spliterator(), true).map(c -> populateVO(c)).collect(Collectors.toList());

    }

    public Iterable<ProductVO> searchProducts(String text) {
        return StreamSupport.stream(productSearchDao.searchProductNameAndDescriptionByKeywordQuery(text).spliterator(), true).map(c -> populateVO(c)).collect(Collectors.toList());

    }


    @Override
    public Iterable<ProductVO> browseProductsByBrand(String brand) {
        return StreamSupport.stream(productRepository.findByBrand(brand).spliterator(), true).map(c -> populateVO(c)).collect(Collectors.toList());
    }

    @Override
    public Iterable<ProductVO> browseProductsByCategory(String cat) {
        return StreamSupport.stream(productRepository.findByCategory(cat).spliterator(), true).map(c -> populateVO(c)).collect(Collectors.toList());
    }

    @Override
    public Iterable<ProductVO> search(String text) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public Iterable<ProductVO> filterProductsByColor(String brand) {
        return StreamSupport.stream(productRepository.findByBrand(brand).spliterator(), true).map(c -> populateVO(c)).collect(Collectors.toList());
    }


    public Iterable<ProductVO> browseByStatus(Integer ratingThreshold) {
        return StreamSupport.stream(productRepository.findByAvgRating(ratingThreshold * 1.0).spliterator(), true).map(c -> populateVO(c)).collect(Collectors.toList());

    }

    @Override
    public Iterable<ProductVO> browseProductsByColor(String color) {
        return StreamSupport.stream(productRepository.findByColor(color).spliterator(), true).map(c -> populateVO(c)).collect(Collectors.toList());

    }


    private ProductVO populateVO(Product c) {
        ProductVO vo = new ProductVO();
        vo.setId(c.getId());
        vo.setName(c.getName());
        vo.setReviews(c.getReviews());
        vo.setCategory(c.getCategory());
        vo.setBrand(c.getBrand());
        IntSummaryStatistics stats = c.getReviews().stream().map(r -> r.getRating())
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        vo.setHot(stats.getCount() >= 5 && stats.getAverage() >= 4);
        vo.setReviewable(!(stats.getCount() >= 5 && stats.getAverage() <= 2));
        vo.setAverageRating(stats.getAverage());
        vo.setShortDesc(c.getName());
        Map<String, ?> map = c.getItems().stream().collect(Collectors.groupingBy(
                m -> m.getColor(), Collectors.groupingBy(m1 -> m1.getSize())));
        vo.setItemKeyMapByColorBySize(map);
        return vo;
    }
}
