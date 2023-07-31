package com.auto.user.services.impl;

import com.auto.user.model.User;
import com.auto.user.repository.UserRepository;
import com.auto.user.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author danilova.tatyana 31.07.2023
 */
@Service
public class UserService implements AbstractService<User> {

    @Autowired
    UserRepository repository;


    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(User body) {
        return false;
    }

    @Override
    public boolean updateById(Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean insert(User body) {
        return false;
    }
}
