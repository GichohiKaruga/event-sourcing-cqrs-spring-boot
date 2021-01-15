package com.java.dev.cqrs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import com.java.dev.cqrs.entity.ProductQueryEntity;
import com.java.dev.cqrs.repository.ProductRepository;


@Service
public class ProductQueryServiceImpl implements ProductQueryService {
	

    private final EventStore eventStore;

    private final ProductRepository productRepository;


    public ProductQueryServiceImpl(EventStore eventStore, ProductRepository productRepository) {
        this.eventStore = eventStore;
        this.productRepository = productRepository;
    }

    @Override
    public List<Object> listEventsForProduct(String productId) {
        return eventStore.readEvents(productId).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
    }

    @Override
    public ProductQueryEntity getProduct(String productId) {
        return productRepository.findById(productId).get();
    }

}
