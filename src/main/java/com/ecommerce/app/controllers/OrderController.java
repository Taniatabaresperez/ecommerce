package com.ecommerce.app.controllers;

import com.ecommerce.app.model.Order;
import com.ecommerce.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/all")
    public List<Order> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return service.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return service.save(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return service.update(order);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> getByZone(@PathVariable("zone") String zone){
        return service.getByZone(zone);
    }

    @GetMapping("/salesman/{id}")
    public List<Order> getBySalesManId(@PathVariable("id") int id){
        return service.getBySalesManId(id);
    }

    @GetMapping("/state/{status}/{id}")
    public List<Order> getBySalesManIdAndStatus(@PathVariable("id") Integer id, @PathVariable("status") String status){
        return service.getBySalesManIdAndStatus(id, status);
    }

    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> getByRegisterDayAndSalesManId(@PathVariable("registerDay") String registerDay, @PathVariable("id") Integer id){
        return service.getByRegisterDayAndSalesManId(registerDay, id);
    }
}
