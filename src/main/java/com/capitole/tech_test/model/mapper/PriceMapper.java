package com.capitole.tech_test.model.mapper;

import com.capitole.tech_test.dto.ProductPriceDTO;
import com.capitole.tech_test.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    ProductPriceDTO priceToProductPriceDTO(Price price);
}
