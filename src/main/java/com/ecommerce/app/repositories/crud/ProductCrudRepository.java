package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Tania Tabares Perez
 */

public interface ProductCrudRepository extends MongoRepository<Product, Integer> {

    Optional<Product> findById(Integer integer);

    public Optional<Product> findTopByOrderByIdDesc();

    public List<Product> findByPrice(double price);

    public List<Product> findByDescriptionContainingIgnoreCase(String description);
}
