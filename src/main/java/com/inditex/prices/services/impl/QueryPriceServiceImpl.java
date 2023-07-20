package com.inditex.prices.services.impl;

import com.inditex.prices.repository.PriceRepository;
import com.inditex.prices.repository.entity.Price;
import com.inditex.prices.services.QueryPriceService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class QueryPriceServiceImpl implements QueryPriceService {

    public QueryPriceServiceImpl(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    private final PriceRepository priceRepository;

    @Override
    public Price queryPrice(String productId, Integer branchId, LocalDateTime queryTime) {
        return priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId,
            branchId, queryTime, queryTime);
    }
}
