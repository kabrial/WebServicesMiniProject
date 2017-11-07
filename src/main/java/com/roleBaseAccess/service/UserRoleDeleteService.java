package com.roleBaseAccess.service;

/**
 * Interface UserRole Service.
 * @author Alexis BARTHELEMY & Kevin ABRIAL.
 *
 */
public interface UserRoleDeleteService {
    
    void deleteUserById(Long id);
    
    void deleteUserRoleByUserid(Long user_id);
}
