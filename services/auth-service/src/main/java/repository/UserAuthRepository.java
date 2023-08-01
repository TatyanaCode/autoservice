package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * author danilova.tatyana 01.08.2023
 */
public interface UserAuthRepository extends JpaRepository<User,Long> {

}
