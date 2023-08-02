package com.auto.auth.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author danilova.tatyana 26.07.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User extends BaseEntity {

    private String username;
    private String password;
    private List<Role> roles;
    private Status status;
}