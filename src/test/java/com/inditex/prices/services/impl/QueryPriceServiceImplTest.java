package com.inditex.prices.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.prices.repository.PriceRepository;
import com.inditex.prices.repository.entity.Price;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class QueryPriceServiceImplTest {

    @InjectMocks
    private QueryPriceServiceImpl queryPriceService;

    @Mock
    private PriceRepository priceRepository;

    @Test
    void whenQueryPrice_shouldQueryToRepositoryProperly() {

        String productId = "35455";
        Integer brandId = 1;
        LocalDateTime queryTime = LocalDateTime.now();
        Price priceMock = mock(Price.class);
        when(priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(eq(productId),
            eq(brandId), eq(queryTime), eq(queryTime))).thenReturn(priceMock);
        assertThat(queryPriceService.queryPrice(productId, brandId, queryTime)).isEqualTo(priceMock);
        verify(priceRepository).findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(eq(productId),
            eq(brandId), eq(queryTime), eq(queryTime));
    }
}