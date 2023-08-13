package com.auto.user.repository;

import com.auto.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * author danilova.tatyana 31.07.2023
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String user);

}
