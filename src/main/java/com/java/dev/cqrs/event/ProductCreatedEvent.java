package com.java.dev.cqrs.event;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class ProductCreatedEvent {
	@TargetAggregateIdentifier
    private String productId;
    private String productname;
    private double price;

    public ProductCreatedEvent(String id, String name, double price) {
    	this.productId = id;
        this.productname = name;
        this.price = price;
    }

}
