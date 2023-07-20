package com.inditex.prices.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.prices.repository.PriceRepository;
import com.inditex.prices.repository.entity.Brand;
import com.inditex.prices.repository.entity.Price;
import com.inditex.prices.restcontroller.dto.PriceDTO;
import java.math.BigDecimal;
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
    void whenQueryPrice_shouldQueryToRepositoryProperlyAndReturnPriceDTO() {

        String productId = "35455";
        Integer brandId = 1;
        LocalDateTime queryTime = LocalDateTime.now();
        Price price = new Price(new Brand(1,"ZARA"), LocalDateTime.now(), LocalDateTime.now() ,
            productId, 1, BigDecimal.valueOf(20d), "EUR" );
        when(priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(eq(productId),
            eq(brandId), eq(queryTime), eq(queryTime))).thenReturn(price);
        PriceDTO priceDTO = queryPriceService.queryPrice(productId, brandId, queryTime);
        assertThat(priceDTO.getPriceId()).isEqualTo(price.getPriceId());
        assertThat(priceDTO.getPrice()).isEqualTo(price.getPrice());
        assertThat(priceDTO.getBrandId()).isEqualTo(price.getBrand().getId());
        assertThat(priceDTO.getCurrency()).isEqualTo(price.getCurrency());
        assertThat(priceDTO.getProductId()).isEqualTo(price.getProductId());
        assertThat(priceDTO.getEndDate()).isEqualTo(price.getEndDate());
        assertThat(priceDTO.getStartDate()).isEqualTo(price.getStartDate());
        verify(priceRepository).findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(eq(productId),
            eq(brandId), eq(queryTime), eq(queryTime));
    }
}