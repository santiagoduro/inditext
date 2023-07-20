package com.inditex.prices.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.inditex.prices.repository.entity.Price;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class IntegrationPriceRepositoryTests {

    @Autowired
    private PriceRepository priceRepository;


    //Test 1: request at 10:00 of day 14 for product 35455 and the brand 1 (ZARA)
    @Test
    public void whenFindByDateForTest1ReturnsPriceCorrectly(){
       Price price1 = priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc("35455",1,
            LocalDateTime.of(2020,Month.JUNE, 14, 10, 0),
           LocalDateTime.of(2020,Month.JUNE, 14, 10, 0));

       assertThat(price1.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(35.50d));
    }

    //Test 2: request at 16:00 of day 14 for product 35455 and the brand 1 (ZARA)
    @Test
    public void whenFindByDateForTest2ReturnsPriceCorrectly(){
        Price price1 = priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc("35455",1,
            LocalDateTime.of(2020,Month.JUNE, 14, 16, 0),
            LocalDateTime.of(2020,Month.JUNE, 14, 16, 0));

        assertThat(price1.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(25.45d));
    }

    //Test 3: request at 21:00 of day 14 for product 35455 and the brand 1 (ZARA)
    @Test
    public void whenFindByDateForTest3ReturnsPriceCorrectly(){
        Price price1 = priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc("35455",1,
            LocalDateTime.of(2020,Month.JUNE, 14, 21, 0),
            LocalDateTime.of(2020,Month.JUNE, 14, 21, 0));

        assertThat(price1.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(35.50d));
    }

    //Test 4: request at 10:00 of day 15 for product 35455 and the brand 1 (ZARA)
    @Test
    public void whenFindByDateForTest4ReturnsPriceCorrectly(){
        Price price1 = priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc("35455",1,
            LocalDateTime.of(2020,Month.JUNE, 15, 10, 0),
            LocalDateTime.of(2020,Month.JUNE, 15, 10, 0));

        assertThat(price1.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(30.50d));
    }

    //Test 5: request at 21:00 of day 16 for product 35455 and the brand 1 (ZARA)
    @Test
    public void whenFindByDateForTest5ReturnsPriceCorrectly(){
        Price price1 = priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc("35455",1,
            LocalDateTime.of(2020,Month.JUNE, 16, 21, 0),
            LocalDateTime.of(2020,Month.JUNE, 16, 21, 0));

        assertThat(price1.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(38.95d));
    }

}
