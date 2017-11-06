package com.roleBaseAccess.service;

import com.roleBaseAccess.model.User;
/**
 * Interface Service User
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface UserService {
    void save(User user);
    
    void saveModifyPassword(User user, long userId);
    
    User displayAUser(User user);

    User findByUsername(String username);
    
    Iterable<User> findAllUsers();
    
    User findUser(Long id);
    
    void saveUser(User user); 
    
    void updateUser(User user, long userId);
}
