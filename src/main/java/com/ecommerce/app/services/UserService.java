package com.ecommerce.app.services;

import com.ecommerce.app.model.User;
import com.ecommerce.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author tania tabares perez
 */

/**
 * Capa de servicios para implementar la lógica de negocio
 */
@Service
public class UserService {

    /**
     * Representa al user repository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Obtiene la lista de usuarios
     * @return
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }

    /**
     * Obtiene un usuario en especifico por medio de su id
     * @param id
     * @return
     */
    public Optional<User> getUser(int id){
        return userRepository.getUserById(id);
    }

    /**
     * Crea un usuario
     * @param user
     * @return
     */
    public User save(User user){
        if (user.getId() == null){
            return user;
        }else{
            Optional<User> dbUser = userRepository.getUserById(user.getId());
            if (dbUser.isEmpty()){
                if(emailExists(user.getEmail()) == false){
                    return userRepository.save(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }

    /**
     * modifica un usuario existente
     * @param user
     * @return
     */
    public User update(User user){
        if (user.getId()!= null){
            Optional<User> dbUser = userRepository.getUserById(user.getId());
            if (!dbUser.isEmpty()) {
                if (user.getIdentification()!= null){
                    dbUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName()!= null){
                    dbUser.get().setName(user.getName());
                }
                if (user.getBirthtDay()!= null){
                    dbUser.get().setName(user.getName());
                }
                if (user.getMonthBirthtDay()!= null){
                    dbUser.get().setName(user.getName());
                }
                if (user.getAddress()!= null){
                    dbUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone()!= null){
                    dbUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail()!= null){
                    dbUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword()!= null){
                    dbUser.get().setPassword(user.getPassword());
                }
                if (user.getZone()!= null){
                    dbUser.get().setZone(user.getZone());
                }
                if (user.getType()!= null){
                    dbUser.get().setType(user.getType());
                }
                userRepository.save(dbUser.get());
                return dbUser.get();
            }else {
                return user;
            }
        }return user;
    }

    /**
     * verifica la existencia de un correo electronico en la base de datos
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    /**
     * Borra un usuario en especifico
     * @param userId
     * @return
     */
    public boolean delete(int userId){
        return getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }

    /**
     * valida si un usuario existe con el correo y contraseñas recibidos
     * @param email
     * @param password
     * @return
     */
    public User authenticateUser(String email, String password){
        Optional<User> user = userRepository.authenticateUser(email, password);
        if (user.isEmpty()){
            return new User();
        }
        return user.get();
    }
}
