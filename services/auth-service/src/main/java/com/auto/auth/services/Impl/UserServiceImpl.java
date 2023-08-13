package com.auto.auth.services.Impl;

import com.auto.auth.model.Role;
import com.auto.auth.model.User;
import com.auto.auth.repository.RoleRepository;
import com.auto.auth.repository.UserRepository;
import com.auto.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * author danilova.tatyana 02.08.2023
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        if (repository.findByUsername(user.getUsername()).isPresent()){
            System.out.println("Имя пользователя занято");
            return;
        }
        Date date = new Date();
        user.setCreated(date);
        user.setUpdated(date);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("USER").get();
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        repository.save(user);
    }
}
