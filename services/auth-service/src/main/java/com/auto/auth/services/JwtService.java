package com.auto.auth.services;

import com.auto.auth.model.Role;
import java.util.List;


/**
 * author danilova.tatyana 01.08.2023
 */
public interface JwtService {
    boolean validateToken(final String token);
    String generateToken(String userName, List<Role> roles);

}
