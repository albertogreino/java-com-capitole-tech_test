package com.capitole.tech_test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class ProductPriceDTO {
    private int productId;
    private int brandId;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;
}
