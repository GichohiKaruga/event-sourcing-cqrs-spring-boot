package com.java.dev.cqrs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dev.cqrs.entity.ProductQueryEntity;
import com.java.dev.cqrs.service.ProductQueryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/products")
@Api(value = "Product Queries")
public class ProductQueryController {

	private final ProductQueryService productQueryService;

    public ProductQueryController(ProductQueryService productQueryService) {
        this.productQueryService = productQueryService;
    }

    @GetMapping("/{productId}")
    public ProductQueryEntity getProduct(@PathVariable(value = "productId") String productId){
        return productQueryService.getProduct(productId);
    }

    @GetMapping("/{productId}/events")
    public List<Object> listEventsForProduct(@PathVariable(value = "productId") String productId){
        return productQueryService.listEventsForProduct(productId);
    }
}
