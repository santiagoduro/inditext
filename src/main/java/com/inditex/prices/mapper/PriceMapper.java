package com.inditex.prices.mapper;

import com.inditex.prices.repository.entity.Price;
import com.inditex.prices.restcontroller.dto.PriceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
    @Mapping(target="brandId", source="price.brand.id")
    PriceDTO convert(Price price);

}
