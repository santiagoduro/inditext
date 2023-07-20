package com.inditex.prices.repository;

import com.inditex.prices.repository.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
