package com.java.dev.cqrs.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class CreateProductCommand {
	@TargetAggregateIdentifier
    private String id;
    private String name;
    private double price;

    public CreateProductCommand(String id, String name, double price) {
    	this.id = id;
        this.name = name;
        this.price = price;
    }
}
