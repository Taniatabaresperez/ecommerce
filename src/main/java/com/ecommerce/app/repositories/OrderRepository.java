package com.ecommerce.app.repositories;

import com.ecommerce.app.model.Order;
import com.ecommerce.app.repositories.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository crudRepository;

    public List<Order> getAll(){
        return crudRepository.findAll();
    }

    public Optional<Order> getOrder(Integer id){
        return crudRepository.findById(id);
    }

    public Order save(Order order){
        return crudRepository.save(order);
    }

    public void update(Order order){
        crudRepository.save(order);
    }

    public void delete(Order order){
        crudRepository.delete(order);
    }

    public Optional<Order> lastOrderId(){
        return crudRepository.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zone){
        return crudRepository.findByZone(zone);
    }
}
