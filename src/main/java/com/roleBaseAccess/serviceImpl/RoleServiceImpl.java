package com.roleBaseAccess.serviceImpl;

/**
 * Class ServiceImpl Role
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roleBaseAccess.model.Role;
import com.roleBaseAccess.repository.RoleRepository;
import com.roleBaseAccess.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    // Repository
    @Autowired
    final RoleRepository roleRepository;
    
    // Contructor
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    /**
     * find all roles
     */
    @Override
    public Iterable<Role> findAllRoles() {
        return roleRepository.findAll();
    }
    
}