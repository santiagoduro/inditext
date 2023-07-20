package com.inditex.prices.restcontroller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PriceDTO {
    private String productId;
    private Integer brandId;
    private Long priceId;
    private LocalDateTime startDate;

    private LocalDateTime endDate;
    private BigDecimal price;
    private String currency;

    public String getProductId() {
        return productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Long getPriceId() {
        return priceId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
