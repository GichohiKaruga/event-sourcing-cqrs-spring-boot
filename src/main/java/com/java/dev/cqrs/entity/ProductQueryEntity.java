package com.java.dev.cqrs.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductQueryEntity {
	
	@Id
	private String id;

	private String name;

	private double price;

}
