package com.java.dev.cqrs.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.java.dev.cqrs.command.CreateProductCommand;
import com.java.dev.cqrs.event.ProductCreatedEvent;

import lombok.Data;


@Data
@Aggregate
public class ProductAggregate {

	@AggregateIdentifier
    private String id;

    private double price;

    private String name;

    public ProductAggregate() {
    }
    
    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
        AggregateLifecycle.apply(new ProductCreatedEvent(createProductCommand.getId(), createProductCommand.getName(), createProductCommand.getPrice()));
    }
    
    @EventSourcingHandler
    protected void on(ProductCreatedEvent productCreatedEvent) {
        this.id = productCreatedEvent.getProductId();
        this.name = productCreatedEvent.getProductname();
        this.price = productCreatedEvent.getPrice();
    }


}
