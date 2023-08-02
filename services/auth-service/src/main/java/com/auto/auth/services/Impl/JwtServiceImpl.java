package com.auto.auth.services.Impl;

import com.auto.auth.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import com.auto.auth.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;;

/**
 * author danilova.tatyana 01.08.2023
 */
@Data
@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    @Autowired
    Environment env;
    private final String secret;
    private final long validityInMilliseconds;


    public JwtServiceImpl(Environment env) {
        this.env = env;
        this.secret = env.getProperty("application.jwt.decodeKey");
        this.validityInMilliseconds = Long.parseLong(Objects.requireNonNull(env.getProperty("application.jwt.expired")));
    }

    public boolean validateToken(final String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            return false;
        }
    }


    public String generateToken(String userName, List<Role> roles) {
        return createToken(userName, roles);
    }

    private String createToken(String userName, List<Role> roles) {
        Claims claims = Jwts.claims().setSubject(userName);
        claims.put("roles", getRoleNames(roles));
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private List<String> getRoleNames(List<Role> userRoles) {
        List<String> result = new ArrayList<>();

        userRoles.forEach(role -> {
            result.add(role.getName());
        });

        return result;
    }
}
