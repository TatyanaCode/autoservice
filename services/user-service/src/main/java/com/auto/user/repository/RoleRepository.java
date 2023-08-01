package com.auto.user.repository;

import com.auto.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author danilova.tatyana 31.07.2023
 */
public interface RoleRepository extends JpaRepository<User, Long> {
}
