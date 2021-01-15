package com.java.dev.cqrs.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dev.cqrs.dto.ProductCreate;
import com.java.dev.cqrs.service.ProductCommandService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/products")
@Api(value = "Product Commands")
public class ProductCommandController {
	
	private final ProductCommandService productService;

    public ProductCommandController(ProductCommandService productService) {
        this.productService = productService;
    }
    
    @PostMapping
    public CompletableFuture<String> CreateProduct(@RequestBody ProductCreate productCreate){
        return productService.CreateProduct(productCreate);
    }

}
