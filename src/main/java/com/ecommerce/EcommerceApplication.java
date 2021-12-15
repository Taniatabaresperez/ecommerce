package com.ecommerce;

import com.ecommerce.app.repositories.OrderRepository;
import com.ecommerce.app.repositories.crud.OrderCrudRepository;
import com.ecommerce.app.repositories.crud.ProductCrudRepository;
import com.ecommerce.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

    @Autowired
    OrderCrudRepository orderCrudRepository;
    @Autowired
    ProductCrudRepository productCrudRepository;
    @Autowired
    UserCrudRepository userCrudRepository;
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderCrudRepository.deleteAll();
        productCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
    }
}
