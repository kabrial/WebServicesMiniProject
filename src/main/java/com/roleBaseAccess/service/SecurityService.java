package com.roleBaseAccess.service;
/**
 * Interface Service Security
 * @author Kevin ABRIAL & Alexis BARTHELEMY
 *
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
