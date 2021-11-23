package com.ecommerce.app.controllers;

import com.ecommerce.app.model.User;
import com.ecommerce.app.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServices service;

    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }

    @PostMapping ("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email")String email){
        return service.getUserByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User existUser(@PathVariable("email")String email, @PathVariable("password")String password){
        return service.getByEmailPass(email, password);
    }

}
