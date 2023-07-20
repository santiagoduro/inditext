package com.inditex.prices.services;

import com.inditex.prices.repository.entity.Price;
import java.time.LocalDateTime;

public interface QueryPriceService {

    Price queryPrice(String productId, Integer branchId, LocalDateTime queryTime);
}
