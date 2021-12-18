package com.ecommerce.app.controllers;

import com.ecommerce.app.model.User;
import com.ecommerce.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tania tabares perez
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/user")
/**
 * Creacion de la clase User controller con el fin de gestionar las peticiones y metodos http
 */
public class UserController {
    /**
     *
     */
    @Autowired
    private UserService userService;

    /**
     * clase que pretende obtener todos los usuarios existentes en la base de datos
     * @return
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    /**
     * clase que pretende obtener un usuario especifico
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    /**
     * clase que permite guardar un usuario nuevo a partir de la peticion save
     * @param user
     * @return
     */
    @PostMapping ("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    /**
     * clase que permite actualizar un usuario
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    /**
     * clase que permite borrar un usuario en especifico
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }

    /**
     * clase que permite validar la existencia de un usuario a partir de su correo y contraseña
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email")String email, @PathVariable("password")String password){
        return userService.authenticateUser(email, password);
    }

    /**
     * clase que permite validar la existencia de un usuario a partir de su correo
     * @param email
     * @return
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email")String email){
        return userService. emailExists(email);
    }

    @GetMapping("/birthday/{month}")
    public List<User> getByMonthBirthtDay(@PathVariable("month") String month){
        return userService.getByMonthBirthtDay(month);
    }

}
