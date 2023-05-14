package com.capitole.tech_test.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PricePK implements Serializable {
    private int brandId;
    private int priceList;
    private int productId;
}
