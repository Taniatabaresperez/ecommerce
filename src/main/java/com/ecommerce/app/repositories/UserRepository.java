package com.ecommerce.app.repositories;

import com.ecommerce.app.model.User;
import com.ecommerce.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Creacion de la clase User Repository
 * @author Tania Tabares Perez
 */
@Repository
public class UserRepository {

    /**
     * establece la coneccion con el Crud Repository
     */
    @Autowired
    private UserCrudRepository repository;

    /**
     * Obtiene todos los usuarios
     * @return una lista de usuarios
     */
    public List<User> getAll(){
        return repository.findAll();
    }

    /**
     * Obtiene un usuario en especifico a partir de su id
     * @param id Integer
     * @return Un usuario con su id o un null
     */
    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }

    /**
     * Guarda un nuevo usuario
     * @param user User object
     * @return user object
     */
    public User save(User user){
        return repository.save(user);
    }

    /**
     * modifica un usuario ya creado
     * @param user User object
     */
    public void update (User user){
        repository.save(user);
    }

    /**
     * Borra un usuario en especifico
     * @param user User object
     */
    public void delete (User user){
        repository.delete(user);
    }

    /**
     * Obtiene un usuario (si existe) a partir de su correo electronico
     * @param email String
     * @return Boolean, true si existe o false si no existe
     */
    public boolean emailExists(String email){
        Optional<User> user = repository.findByEmail(email);
        return user.isPresent();
    }

    /**
     * Obtiene un usuario con su correo y contraseña
     * @param email String
     * @param password String
     * @return un usuario con estas credenciales
     */
    public Optional<User> authenticateUser(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }

    /**
     * Obtiene el usario que tenga el mayor id
     * @return User object
     */
    public Optional<User> lastUserId(){
        return repository.findTopByOrderByIdDesc();
    }

    /**
     *Obtiene un usuario a partir de su mes de cumpleaños
     * @param month String
     * @return una lista de usuarios
     */
    public List<User> getByMonthBirthtDay(String month){
        return repository.findByMonthBirthtDay(month);
    }
}
