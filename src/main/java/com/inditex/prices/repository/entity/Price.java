package com.inditex.prices.repository.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
public class Price {
    public Price(){}

    public Price(Brand brand, LocalDateTime startDate, LocalDateTime endDate, String productId, Integer priority,
        BigDecimal price, String currency) {
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceId;

    @ManyToOne()
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String productId;

    private Integer priority;

    private BigDecimal price;


    private String currency;

    public Long getPriceId() {
        return priceId;
    }

    public Brand getBrand() {
        return brand;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
