package com.auto.auth.repository;

import com.auto.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * author danilova.tatyana 01.08.2023
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
