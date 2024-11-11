package com.springbootweek3cw.springbootweek3cw.repositories;

import com.springbootweek3cw.springbootweek3cw.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findBy(Sort sort);


    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal price);
    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

   // Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}