package com.auto.user.controllers;

import com.auto.user.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author danilova.tatyana 31.07.2023
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractController<User>{
}
