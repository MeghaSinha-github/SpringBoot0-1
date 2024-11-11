package com.springbootweek3cw.springbootweek3cw.controllers;


import com.springbootweek3cw.springbootweek3cw.entities.ProductEntity;
import com.springbootweek3cw.springbootweek3cw.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final int page_size = 5;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getProducts(@RequestParam(defaultValue = "") String title,
                                           @RequestParam(defaultValue = "id") String sortBy,
                                           @RequestParam(defaultValue = "0") Integer pageNum) {
        //  return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price"));
//        return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy),
//                Sort.Order.desc("title")));
        Pageable pageable = PageRequest.of(pageNum, page_size, Sort.by(sortBy));
        return productRepository.findByTitleContainingIgnoreCase(title,pageable);
    }
}
