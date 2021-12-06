package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductCrudRepository extends MongoRepository<Product, Integer> {

    Optional<Product> findById(Integer integer);

    public Optional<Product> findTopByOrderByIdDesc();
}
