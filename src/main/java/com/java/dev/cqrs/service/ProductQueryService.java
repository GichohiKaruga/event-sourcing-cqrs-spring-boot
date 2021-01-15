package com.java.dev.cqrs.service;

import java.util.List;

import com.java.dev.cqrs.entity.ProductQueryEntity;


public interface ProductQueryService {
	public List<Object> listEventsForProduct(String productId);
    public ProductQueryEntity getProduct(String productId);
}
