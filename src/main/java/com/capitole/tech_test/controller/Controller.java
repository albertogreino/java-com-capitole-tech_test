package com.capitole.tech_test.controller;

import com.capitole.tech_test.controller.request.PriceRequest;
import com.capitole.tech_test.dto.ProductPriceDTO;
import com.capitole.tech_test.service.ProductService;
import com.capitole.tech_test.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final ProductService productService;

    @Autowired
    public Controller(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/product-price")
    public ResponseEntity<ProductPriceDTO> getProductPriceByDateAndBrand(
            @RequestBody PriceRequest priceRequest) {
        ProductPriceDTO result = productService.getProductPriceByDateAndBrand(priceRequest);

        if (result == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }
}
