package com.roleBaseAccess.service;

import com.roleBaseAccess.model.Role;
/**
 * Interface Service Role
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface RoleService {
    Iterable<Role> findAllRoles();
}
