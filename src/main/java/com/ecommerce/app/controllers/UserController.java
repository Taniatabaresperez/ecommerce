package com.ecommerce.app.controllers;

import com.ecommerce.app.model.User;
import com.ecommerce.app.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author tania tabares perez
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("user")
/**
 * Creacion de la clase User controller con el fin de establecer las peticiones
 */
public class UserController {
    /**
     *
     */
    @Autowired
    private UserServices service;

    /**
     * clase que pretende obtener todos los usuarios existentes en la base de datos
     * @return
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }

    /**
     * clase que permite guardar un usuario nuevo a partir de la peticion save
     * @param user
     * @return
     */
    @PostMapping ("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }

    /**
     * clase que permite validar la existencia de un usuario a partir de su correo
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email")String email){
        return service. getUserByEmail(email);
    }

    /**
     * clase que permite validar la existencia de un usuario a partir de su correo y contraseña
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User existUser(@PathVariable("email")String email, @PathVariable("password")String password){
        return service.getByEmailPass(email, password);
    }

}
