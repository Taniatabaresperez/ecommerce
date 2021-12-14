package com.ecommerce.app.services;


import com.ecommerce.app.model.Order;
import com.ecommerce.app.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> getAll(){
        return repository.getAll();
    }

    public Optional<Order> getOrder(int id){
        return repository.getOrder(id);
    }

    public Order save(Order order){
        Optional<Order> orderMaxId = repository.lastOrderId();
        if (order.getId() == null){
            if (orderMaxId.isPresent()){
                order.setId(orderMaxId.get().getId() + 1);
            }else {
                order.setId(1);
            }
        }
        Optional<Order> dbOrder = repository.getOrder(order.getId());
        if (dbOrder.isEmpty()){
            return repository.save(order);
        }
        order.setId(null);
        return order;
    }

    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> orderTemp = repository.getOrder(order.getId());
            if (orderTemp.isPresent()){
                if (order.getStatus() != null){
                    orderTemp.get().setStatus(order.getStatus());
                }
                repository.update(orderTemp.get());
                return orderTemp.get();
            }
            return order;
        }
        return order;
    }

    public boolean delete(int id){
        return getOrder(id).map(order -> {
            repository.delete(order);
            return true;
        }).orElse(false);
    }

    public List<Order> getByZone(String zone){
        return repository.findByZone(zone);
    }
}
