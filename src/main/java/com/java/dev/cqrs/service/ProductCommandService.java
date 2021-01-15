package com.java.dev.cqrs.service;

import java.util.concurrent.CompletableFuture;

import com.java.dev.cqrs.dto.ProductCreate;


public interface ProductCommandService {
    public CompletableFuture<String> CreateProduct(ProductCreate productCreate);

}
