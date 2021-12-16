//package com.ecommerce.app.repositories.crud;
//
//import com.ecommerce.app.model.Order;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
//
//    @Query("{'salesMan.zone': ?0}")
//    List<Order> findByZone(final String zone);
//
//    @Query("{status: ?0}")
//    List<Order> findByStatus(final String status);
//
//    public Optional<Order> findTopByOrderByIdDesc();
//
//    List<Order> findBySalesManId(Integer id);
//
//    List<Order> findBySalesManIdAndStatus(Integer id, String status);
//}
