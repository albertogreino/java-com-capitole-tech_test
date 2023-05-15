package com.capitole.tech_test.service.impl;

import com.capitole.tech_test.controller.request.PriceRequest;
import com.capitole.tech_test.dto.ProductPriceDTO;
import com.capitole.tech_test.model.Price;
import com.capitole.tech_test.model.mapper.PriceMapper;
import com.capitole.tech_test.repository.PricesRepository;
import com.capitole.tech_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final PricesRepository pricesRepository;
    private final PriceMapper priceMapper;

    @Autowired
    public ProductServiceImpl(PricesRepository pricesRepository, PriceMapper priceMapper) {
        this.pricesRepository = pricesRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public ProductPriceDTO getProductPriceByDateAndBrand(PriceRequest request) {
        List<Price> result = pricesRepository.findProductPriceByDateAndBrand(request.getBrandId(),
                request.getProductId(), request.getDate());

        if (CollectionUtils.isEmpty(result)) {
            return null;
        }

        return priceMapper.priceToProductPriceDTO(result.get(0));
    }
}
