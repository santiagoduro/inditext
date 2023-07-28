package com.inditex.prices;

import com.inditex.prices.repository.BrandRepository;
import com.inditex.prices.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PricesApplication{

	public static void main(String[] args) {
		SpringApplication.run(PricesApplication.class, args);
	}
}
