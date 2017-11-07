package com.roleBaseAccess.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roleBaseAccess.repository.UserRepository;
import com.roleBaseAccess.repository.UserRoleRepository;
import com.roleBaseAccess.service.UserRoleDeleteService;

/**
 * UserRoleServiceImpl.
 * @author Alexis BARTHELEMY & Kevin ABRIAL.
 *
 */
@Service
public class UserRoleDeleteServiceImpl implements UserRoleDeleteService {
    
    // Repository
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    
    /**
     * delete account
     * @param id
     */
    @Override
    public void deleteUserById(Long id) {
        userRepository.delete(id);
    }
    
    /**
     * delete user_role
     * @param user_id
     */
    @Override
    public void deleteUserRoleByUserid(Long user_id) {
        userRoleRepository.delete(user_id);
    }
}
