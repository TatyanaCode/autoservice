package com.auto.auth.dao;

import com.auto.auth.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author danilova.tatyana 01.08.2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    private String username;
    private String password;

    public User toUser() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        return user;
    }
}
