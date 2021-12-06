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

    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }

    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }

    public User save(User user){
        return repository.save(user);
    }

    public void update (User user){
        repository.save(user);
    }

    public void delete (User user){
        repository.delete(user);
    }

    public boolean emailExists(String email){
        Optional<User> user = repository.findByEmail(email);
        return user.isPresent();
    }

    public Optional<User> authenticateUser(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }
}
