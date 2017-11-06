package com.roleBaseAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roleBaseAccess.model.User;
/**
 * Repository User
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
