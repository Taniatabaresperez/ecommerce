package com.ecommerce.app.repositories;

import com.ecommerce.app.model.User;
import com.ecommerce.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository repository;

    /**
     *
     * @return
     */
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }

    /**
     *
     * @param user
     * @return
     */
    public User save(User user){
        return repository.save(user);
    }

    /**
     *
     * @param name
     * @return
     */
    public Optional<User> getUserByName(String name){
        return repository.findByName(name);
    }

    /**
     *
     * @param email
     * @return
     */
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }

    /**
     *
     * @param name
     * @param email
     * @return
     */
    public List<User> getUsersByNameOrEmail(String name, String email){
        return repository.findByNameOrEmail(name, email);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> getUserEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }


}
