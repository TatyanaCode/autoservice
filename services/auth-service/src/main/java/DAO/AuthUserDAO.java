package DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author danilova.tatyana 01.08.2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Users")
public class AuthUserDAO {
    private String username;
    private String password;

}
