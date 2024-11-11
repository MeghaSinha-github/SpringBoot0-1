package com.springbootweek3cw.springbootweek3cw;

import com.springbootweek3cw.springbootweek3cw.entities.ProductEntity;
import com.springbootweek3cw.springbootweek3cw.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Springbootweek3cwApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testRepository() {
        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle1234")
                .title("Nestle")
                .price(BigDecimal.valueOf(121.45))
                .quantity(4)
                .build();
        ProductEntity saveProductEntity = productRepository.save(productEntity);
        System.out.println(saveProductEntity);
    }

    @Test
    void getRepository() {
        //List<ProductEntity> productEntities=productRepository.findByTitle("Pepsi");
//        List<ProductEntity> productEntities = productRepository.
//                findByCreatedAtAfter(LocalDateTime.of(2024, 1, 1, 0, 0, 0));
       // List<ProductEntity> productEntities = productRepository.findByQuantityGreaterThanAndPriceLessThan(4, BigDecimal.valueOf(121.45));
        List<ProductEntity> productEntities = productRepository.findByTitleContainingIgnoreCase("Co", null);
        System.out.println(productEntities);
    }


    @Test
    void getSingleFromRepository(){
        Optional<ProductEntity> productEntity= productRepository.findByTitleAndPrice("Pepsi",BigDecimal.valueOf(12.4));
        productEntity.ifPresent(System.out::println);

    }
}
