package com.auto.user.model;

import java.util.List;

/**
 * author danilova.tatyana 26.07.2023
 */
public class User extends BaseEntity {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Role> roles;
    private Status status;
}

