package com.auto.auth.controllers;

import com.auto.auth.dao.UserDAO;
import com.auto.auth.repository.UserRepository;
import com.auto.auth.services.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * author danilova.tatyana 02.08.2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class Controller {
    private UserServiceImpl service;
    private UserRepository repository;

    public Controller(UserServiceImpl authService, UserRepository repository) {
        this.service = authService;
        this.repository = repository;
    }

    @PostMapping("/registr")
    public void registration(@RequestBody UserDAO userDAO) {
        service.saveUser(userDAO.toUser());
    }


}
