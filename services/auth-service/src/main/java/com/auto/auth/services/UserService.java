package com.auto.auth.services;

import com.auto.auth.model.User;

import java.util.Optional;

/**
 * author danilova.tatyana 01.08.2023
 */

public interface UserService {
    Optional<User> findUserByUsername(String username) ;
    void saveUser(User user);
}
