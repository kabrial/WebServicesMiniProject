package com.roleBaseAccess.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.roleBaseAccess.model.User;
import com.roleBaseAccess.repository.RoleRepository;
import com.roleBaseAccess.repository.UserRepository;
import com.roleBaseAccess.service.UserService;

import java.util.HashSet;
/**
 * Class ServiceImpl user
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
@Service
public class UserServiceImpl implements UserService {
    // Repository
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    // Password Crypt with BCryptPasswordEncoder.
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    /**
     * save a user defaut role : SALES
     */
    @Override
    public void save(User user) {
        String roleAssignByDefautValue = "SALES";
        long valueOfRole = 2;
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUserrole(roleAssignByDefautValue);
        user.setRoles(new HashSet<>(roleRepository.findById(valueOfRole)));
        userRepository.save(user);
    }
    
    /**
     * modify password in your profil
     */
    @Override
    public void saveModifyPassword(User user, long userId) {
        User userEntity = userRepository.findOne(userId);
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(userEntity);
    }
    
    /**
     * display user by one 
     */
    @Override
    public User displayAUser(User user) {
        return userRepository.findOne(user.getId());
    }

    /**
     * find Username
     */
    @Override
    public User findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    /** 
     * find all users
     */
    @Override
    public Iterable<User> findAllUsers() {

        return userRepository.findAll();
    }

    /** 
     * find one user
     */
    @Override
    public User findUser(Long id) {

        return userRepository.findOne(id);
    }

    /**
     * save a user
     */
    @Override
    public void saveUser(User user) {

        userRepository.save(user);
    }

    /**
     * update role of a user (only access for 'ADMIN')
     */
    @Override
    public void updateUser(User user, long userId) {

        User userEntity = userRepository.findOne(userId);
        userEntity.setUserrole(user.getUserrole());
        userRepository.save(userEntity);
    }
    
  
}
