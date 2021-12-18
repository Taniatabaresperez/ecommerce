package com.ecommerce.app.repositories;

import com.ecommerce.app.model.Product;
import com.ecommerce.app.repositories.crud.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return productCrudRepository.findAll();
    }

    public Optional<Product> getProduct(int id){
        return productCrudRepository.findById(id);
    }

    public Product save(Product product){
        return productCrudRepository.save(product);
    }

     public void update(Product product){
        productCrudRepository.save(product);
     }

    public void delete(Product product){
        productCrudRepository.delete(product);
    }

    public Optional<Product> lastProductId(){
        return productCrudRepository.findTopByOrderByIdDesc();
    }

    public List<Product> getByPrice(double price){
        return productCrudRepository.findByPrice(price);
    }

    public List<Product> getByDescriptionContains(String description){
        return productCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}
