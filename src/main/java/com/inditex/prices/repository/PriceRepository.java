package com.inditex.prices.repository;

import com.inditex.prices.repository.entity.Price;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {

    Price findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(String productId, Integer brandId,
        LocalDateTime startQueryDate, LocalDateTime endQueryDate);

}
