package com.capitole.tech_test.service;

import com.capitole.tech_test.controller.request.PriceRequest;
import com.capitole.tech_test.dto.ProductPriceDTO;

public interface ProductService {
    ProductPriceDTO getProductPriceByDateAndBrand(PriceRequest request);
}
