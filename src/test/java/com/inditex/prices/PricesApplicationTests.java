package com.inditex.prices;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inditex.prices.repository.PriceRepository;
import com.inditex.prices.repository.entity.Price;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class PricesApplicationTests {

	private static final String API_PRICE = "/price";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PriceRepository priceRepository;

	//Test 1: request at 10:00 of day 14 for product 35455 and the brand 1 (ZARA)
	@Test
	public void whenFindByDateForTest1ReturnsPriceCorrectly() throws Exception {
		Price price1 = priceRepository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc("35455",1,
			LocalDateTime.of(2020, Month.JUNE, 14, 10, 0),
			LocalDateTime.of(2020,Month.JUNE, 14, 10, 0));

		mockMvc.perform(MockMvcRequestBuilders.get(API_PRICE)
				.queryParam("queryDateTime", "2020-06-14T10:00:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1")
			.accept(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(BigDecimal.valueOf(35.50d)));

	}

}
