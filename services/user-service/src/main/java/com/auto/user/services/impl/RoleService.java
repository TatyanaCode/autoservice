package com.auto.user.services.impl;

import com.auto.user.model.Role;
import com.auto.user.repository.RoleRepository;
import com.auto.user.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author danilova.tatyana 31.07.2023
 */
@Service
public class RoleService implements AbstractService<Role> {

    @Autowired
    RoleRepository repository;
    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public boolean update(Role body) {
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
    public boolean insert(Role body) {
        return false;
    }
}
