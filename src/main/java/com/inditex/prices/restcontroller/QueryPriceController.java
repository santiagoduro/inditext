package com.inditex.prices.restcontroller;

import com.inditex.prices.restcontroller.dto.PriceDTO;
import com.inditex.prices.services.QueryPriceService;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryPriceController
{
    private final QueryPriceService queryPriceService;

    public QueryPriceController(QueryPriceService queryPriceService) {
        this.queryPriceService = queryPriceService;
    }

    @GetMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDTO> getPrice(
        @RequestParam(value = "queryDateTime") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime queryDateTime,
        @RequestParam(value = "productId") String productId,
        @RequestParam(value = "brandId") Integer brandId){
        return ResponseEntity.ok(queryPriceService.queryPrice(productId, brandId, queryDateTime));
    }

}
