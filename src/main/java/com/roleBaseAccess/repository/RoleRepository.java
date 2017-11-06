package com.roleBaseAccess.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roleBaseAccess.model.Role;
/**
 * Repository Role
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
    
    List<Role> findById(Long id);
}
