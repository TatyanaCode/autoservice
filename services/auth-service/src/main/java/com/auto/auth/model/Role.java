package com.auto.auth.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author danilova.tatyana 26.07.2023
 */

@AllArgsConstructor
@NoArgsConstructor

public class Role  extends BaseEntity{
    private String roleName;
    private List<User> users;


    public String getName() {
        return roleName;
    }
}
