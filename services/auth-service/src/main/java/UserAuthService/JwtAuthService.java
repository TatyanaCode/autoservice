package UserAuthService;

import model.Role;
import java.util.List;


/**
 * author danilova.tatyana 01.08.2023
 */
public interface JwtAuthService {
    boolean validateToken(final String token);
    String generateToken(String userName, List<Role> roles);
}
