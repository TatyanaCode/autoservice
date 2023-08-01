package UserAuthService;

import model.Role;
import model.User;

import java.util.List;
import java.util.Optional;

/**
 * author danilova.tatyana 01.08.2023
 */
public interface UserAuthService {
    void saveUser(User user);
    String generateToken(String username, List<Role> roles);
    boolean validateToken(String token);
    Optional<User> getUser(String username);
}
