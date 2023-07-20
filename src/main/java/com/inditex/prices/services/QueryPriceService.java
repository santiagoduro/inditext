package com.inditex.prices.services;

import com.inditex.prices.restcontroller.dto.PriceDTO;
import java.time.LocalDateTime;

public interface QueryPriceService {

    PriceDTO queryPrice(String productId, Integer branchId, LocalDateTime queryTime);
}
