package com.java.dev.cqrs.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;

import com.java.dev.cqrs.command.CreateProductCommand;
import com.java.dev.cqrs.dto.ProductCreate;

public class ProductCommandServiceImpl implements ProductCommandService {
	
	private final CommandGateway commandGateway;

    public ProductCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

	@Override
	public CompletableFuture<String> CreateProduct(ProductCreate productCreate) {
		return commandGateway.send(new CreateProductCommand(UUID.randomUUID().toString(), productCreate.getName(), productCreate.getPrice()));
	}


}
