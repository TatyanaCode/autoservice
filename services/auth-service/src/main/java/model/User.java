package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author danilova.tatyana 26.07.2023
 */
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    private String username;
    private String password;
    private List<Role> roles;
    private Status status;
}
