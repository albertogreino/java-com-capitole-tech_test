package com.capitole.tech_test.repository;

import com.capitole.tech_test.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Price, Integer> {
    @Query(value = "SELECT * FROM PRICES WHERE BRAND_ID = :brandId AND PRODUCT_ID = :productId AND :date BETWEEN START_DATE AND END_DATE ORDER BY PRIORITY DESC", nativeQuery = true)
    List<Price> findProductPriceByDateAndBrand(@Param("brandId") Integer brandId,
                                               @Param("productId") Integer productId,
                                               @Param("date") LocalDateTime date);
}
