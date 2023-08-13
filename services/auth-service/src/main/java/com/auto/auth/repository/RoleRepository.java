package com.auto.auth.repository;

import com.auto.auth.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



/**
 * author danilova.tatyana 03.08.2023
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role>findByName(String rolename);
}
