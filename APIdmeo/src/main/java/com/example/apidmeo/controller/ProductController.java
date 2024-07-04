package com.example.apidmeo.controller;

import com.example.apidmeo.service.ProductSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductSummaryService productSummaryService;

    public static class ProductSummary {
        private String productId;
        private String category;
        private BigDecimal price;

        public ProductSummary() {}

        public ProductSummary(String productId, String category, BigDecimal price) {
            this.productId = productId;
            this.category = category;
            this.price = price;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }

    @GetMapping("/productId/{productId}")
    public Map<String, Object> getProductInfo(@PathVariable("productId") String productId) {
        ProductSummary productSummary = productSummaryService.getProductInfo(productId);
        Map<String, Object> response = new HashMap<>();

        if (productSummary != null) {
            response.put("price", productSummary.getPrice());
            response.put("category", productSummary.getCategory());
        } else {
            response.put("error", "Product not found");
        }

        return response;
    }
}


