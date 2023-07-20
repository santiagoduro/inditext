package com.inditex.prices.services.impl;

import com.inditex.prices.exception.PriceNotFound;
import com.inditex.prices.mapper.PriceMapper;
import com.inditex.prices.repository.PriceRepository;
import com.inditex.prices.repository.entity.Price;
import com.inditex.prices.restcontroller.dto.PriceDTO;
import com.inditex.prices.services.QueryPriceService;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class QueryPriceServiceImpl implements QueryPriceService {

    public QueryPriceServiceImpl(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    private final PriceRepository priceRepository;

    @Override
    public PriceDTO queryPrice(String productId, Integer brandId, LocalDateTime queryTime) {
        Price price = priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId,
            brandId, queryTime, queryTime);
        Optional.ofNullable(price).map(PriceMapper.INSTANCE::convert)
            .orElseThrow(() -> new PriceNotFound("Price not found for the queryTime: " + queryTime + ","
                + "productId: " + productId + " and brandId: " + brandId));
        return PriceMapper.INSTANCE.convert(price);
    }
}
