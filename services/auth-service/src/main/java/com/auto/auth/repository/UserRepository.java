package com.auto.auth.repository;

import com.auto.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * author danilova.tatyana 01.08.2023
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {



     Optional<User> findByUsername(String username);

}
