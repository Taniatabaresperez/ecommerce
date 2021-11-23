package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
    /**
     *
     * @param name
     * @return
     */
    public Optional<User> findByName(String name);

    /**
     *
     * @param email
     * @return
     */
    public Optional<User> findByEmail(String email);

    /**
     *
     * @param name
     * @param email
     * @return
     */
    public List<User> findByNameOrEmail(String name, String email);

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
}
