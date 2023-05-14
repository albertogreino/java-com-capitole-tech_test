package com.capitole.tech_test.controller;

import com.capitole.tech_test.controller.request.PriceRequest;
import com.capitole.tech_test.dto.ProductPriceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/product-price")
    public ResponseEntity<ProductPriceDTO> getProductPriceByDateAndBrand(
            @RequestBody PriceRequest priceRequest) {
        return ResponseEntity.ok().build();
    }
}
