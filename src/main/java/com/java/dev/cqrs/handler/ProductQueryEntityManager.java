package com.java.dev.cqrs.handler;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.java.dev.cqrs.aggregate.ProductAggregate;
import com.java.dev.cqrs.entity.ProductQueryEntity;
import com.java.dev.cqrs.event.ProductCreatedEvent;
import com.java.dev.cqrs.repository.ProductRepository;


@Component
public class ProductQueryEntityManager {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    @Qualifier("productAggregateEventSourcingRepository")
    private EventSourcingRepository<ProductAggregate> productAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(ProductCreatedEvent event){
        persistProduct(buildQueryProduct(getProductFromEvent(event)));
    }


    private ProductAggregate getProductFromEvent(ProductCreatedEvent productCreatedEvent){
        return productAggregateEventSourcingRepository.load(productCreatedEvent.getProductId()).getWrappedAggregate().getAggregateRoot();
    }

    private ProductQueryEntity findExistingOrCreateQueryProduct(String id){
        return productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : new ProductQueryEntity();
    }

    private ProductQueryEntity buildQueryProduct(ProductAggregate productAggregate){
        ProductQueryEntity productQueryEntity = findExistingOrCreateQueryProduct(productAggregate.getId());

        productQueryEntity.setId(productAggregate.getId());
        productQueryEntity.setName(productAggregate.getName());
        productQueryEntity.setPrice(productAggregate.getPrice());

        return productQueryEntity;
    }

    private void persistProduct(ProductQueryEntity productQueryEntity){
        productRepository.save(productQueryEntity);
    }
}