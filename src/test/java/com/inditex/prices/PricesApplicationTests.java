package com.inditex.prices;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inditex.prices.repository.PriceRepository;
import java.math.BigDecimal;
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
	public void whenQueryPriceForTest1ReturnsPriceCorrectly() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get(API_PRICE)
				.queryParam("queryDateTime", "2020-06-14T10:00:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1")
			.accept(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(BigDecimal.valueOf(35.50d)))
			.andExpect(jsonPath("$.currency").value("EUR"))
			.andExpect(jsonPath("$.productId").value("35455"))
			.andExpect(jsonPath("$.brandId").value(1))
			.andExpect(jsonPath("$.priceId").value(1))
			.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
			.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"));

	}

	//Test 2: request at 16:00 of day 14 for product 35455 and the brand 1 (ZARA)
	@Test
	public void whenQueryPriceForTest2ReturnsPriceCorrectly() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(API_PRICE)
				.queryParam("queryDateTime", "2020-06-14T16:00:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1")
				.accept(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(BigDecimal.valueOf(25.45d)))
			.andExpect(jsonPath("$.currency").value("EUR"))
			.andExpect(jsonPath("$.productId").value("35455"))
			.andExpect(jsonPath("$.brandId").value(1))
			.andExpect(jsonPath("$.priceId").value(2))
			.andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
			.andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"));
	}

	//Test 3: request at 21:00 of day 14 for product 35455 and the brand 1 (ZARA)
	@Test
	public void whenQueryPriceForTest3ReturnsPriceCorrectly() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(API_PRICE)
				.queryParam("queryDateTime", "2020-06-14T21:00:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1")
				.accept(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(BigDecimal.valueOf(35.50d)))
			.andExpect(jsonPath("$.currency").value("EUR"))
			.andExpect(jsonPath("$.productId").value("35455"))
			.andExpect(jsonPath("$.brandId").value(1))
			.andExpect(jsonPath("$.priceId").value(1))
			.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
			.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"));
	}

	//Test 4: request at 10:00 of day 15 for product 35455 and the brand 1 (ZARA)
	@Test
	public void whenQueryPriceForTest4ReturnsPriceCorrectly() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(API_PRICE)
				.queryParam("queryDateTime", "2020-06-15T10:00:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1")
				.accept(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(BigDecimal.valueOf(30.50d)))
			.andExpect(jsonPath("$.currency").value("EUR"))
			.andExpect(jsonPath("$.productId").value("35455"))
			.andExpect(jsonPath("$.brandId").value(1))
			.andExpect(jsonPath("$.priceId").value(3))
			.andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
			.andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"));

	}

	//Test 5: request at 21:00 of day 16 for product 35455 and the brand 1 (ZARA)
	@Test
	public void whenQueryPriceForTest5ReturnsPriceCorrectly() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(API_PRICE)
				.queryParam("queryDateTime", "2020-06-16T21:00:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1")
				.accept(APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.price").value(BigDecimal.valueOf(38.95d)))
			.andExpect(jsonPath("$.currency").value("EUR"))
			.andExpect(jsonPath("$.productId").value("35455"))
			.andExpect(jsonPath("$.brandId").value(1))
			.andExpect(jsonPath("$.priceId").value(4))
			.andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
			.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"));

	}

	@Test
	public void whenQueryPriceDoesNotFoundAnyPrice() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(API_PRICE)
				.queryParam("queryDateTime", "2019-06-16T21:00:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1")
				.accept(APPLICATION_JSON_VALUE))
			.andExpect(status().isNotFound());
	}

}
