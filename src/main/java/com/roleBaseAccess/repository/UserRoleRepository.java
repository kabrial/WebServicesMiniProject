package com.roleBaseAccess.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.roleBaseAccess.model.UserRole;

/**
 * Repository Role
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

  
}
