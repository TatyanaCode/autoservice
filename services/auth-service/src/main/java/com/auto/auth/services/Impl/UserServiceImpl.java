package com.auto.auth.services.Impl;

import com.auto.auth.model.User;
import com.auto.auth.repository.UserRepository;
import com.auto.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * author danilova.tatyana 02.08.2023
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public Optional<User> getUser(String username) {
        return Optional.empty();
    }
}
