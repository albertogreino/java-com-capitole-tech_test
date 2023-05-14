package com.capitole.tech_test.service.impl;

import com.capitole.tech_test.controller.request.PriceRequest;
import com.capitole.tech_test.dto.ProductPriceDTO;
import com.capitole.tech_test.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductPriceDTO getProductPriceByDateAndBrand(PriceRequest request) {
        return null;
    }
}
