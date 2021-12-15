package com.ecommerce.app.repositories;

import com.ecommerce.app.model.Order;
import com.ecommerce.app.repositories.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

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

    public List<Order> getBySalesManId(Integer id){
        return crudRepository.findBySalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return crudRepository.findBySalesManIdAndStatus(id, status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(registerDay, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(registerDay, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        return mongoTemplate.find(query,Order.class);
    }
}
