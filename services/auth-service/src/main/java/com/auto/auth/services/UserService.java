package com.auto.auth.services;

import com.auto.auth.model.Role;
import com.auto.auth.model.User;

import java.util.List;
import java.util.Optional;

/**
 * author danilova.tatyana 01.08.2023
 */

public interface UserService {
    void saveUser(User user);
    Optional<User> getUser(String username);
}
