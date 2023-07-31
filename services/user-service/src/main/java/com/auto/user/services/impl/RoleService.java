package com.auto.user.services.impl;

import com.auto.user.model.Role;
import com.auto.user.services.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author danilova.tatyana 31.07.2023
 */
@Service
public class RoleService implements AbstractService<Role> {
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
