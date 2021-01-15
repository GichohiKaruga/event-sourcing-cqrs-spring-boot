package com.java.dev.cqrs.repository;


import org.springframework.data.repository.CrudRepository;

import com.java.dev.cqrs.entity.ProductQueryEntity;

public interface ProductRepository extends CrudRepository<ProductQueryEntity, String> {

}
